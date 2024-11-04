package com.drl.controller;

import com.drl.daos.DBConnect;
import com.drl.daos.Giang_Vien_dao;
import com.drl.daos.Khoa_Hoc_dao;
import com.drl.daos.Khoa_dao;
import com.drl.daos.Lop_dao;
import com.drl.models.Giang_Vien;
import com.drl.models.Lop;
import com.drl.models.Khoa;
import com.drl.models.Khoa_Hoc;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import com.drl.tools.ThreadPool;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/khoa_lop"})
public class khoa_lop extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private List<Lop> lop = null;
    private Khoa kh = null;
    private ArrayList<Khoa> khoa = null;
    private ArrayList<Giang_Vien> dsgv = null;
    private ArrayList<Giang_Vien> dsgv2 = null;
    private ArrayList<Khoa_Hoc> khList = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InterruptedException, ExecutionException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Kiểm tra đã từng đăng nhập
        Connection con = null;
        con = DBConnect.getConnection();
        if (con == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/alert/overload.jsp");
            dispatcher.forward(request, response);
            return;
        }
        HttpSession session = request.getSession(false);
        String username = null;

        if (session != null) {
            username = (String) session.getAttribute("username");
        }

        if (null == username) {
            String message = URLEncoder.encode("Vui lòng đăng nhập!", "UTF-8");
            String link = "/login_alert?message=" + message;
            response.sendRedirect(request.getContextPath() + link);

        } else {
            switch (username) {
                case "": {
                    String message = URLEncoder.encode("Vui lòng đăng nhập!", "UTF-8");
                    String link = "/login_alert?message=" + message;
                    response.sendRedirect(request.getContextPath() + link);
                    break;
                }
                default:
                    if ((int) session.getAttribute("rule") != 2) {
                        response.sendRedirect("login");
                        return;
                    }
                    Future<Void> future = ThreadPool.executorService.submit(() -> {
                        boolean flag = true;

                        //Cập nhật thông tin lớp
                        if (request.getParameter("lopid") != null
                                && request.getParameter("khoamoi") != null
                                && request.getParameter("lopcu") != null
                                && request.getParameter("gvmoi") != null
                                && request.getParameter("khoahocmoi") != null) {
                            Lop lop2 = new Lop_dao().getLop_by_ID(request.getParameter("lopcu"));
                            if (!request.getParameter("lopid").equals("") && request.getParameter("lopid") != null) {
                                lop2.setTen(request.getParameter("lopid"));
                            }
                            boolean f = false;
                            if (!request.getParameter("lopid").toLowerCase().equals(request.getParameter("tenlopcu").toLowerCase())) {
                                if (new Lop_dao().isTenLopDuplicate(request.getParameter("lopid"))) {
                                    request.setAttribute("message", "Lớp đã tồn tại trên hệ thống!");
                                    f = true;
                                }
                            }
                            if (f == false) {
                                Giang_Vien gvm = new Giang_Vien_dao().getGiangVien_by_ID(request.getParameter("gvmoi"));
                                lop2.setKhoaID(gvm.getKhoaID());
                                lop2.setGiangVienID(request.getParameter("gvmoi"));
                                lop2.setKhoaHocID(Integer.parseInt(request.getParameter("khoahocmoi")));
                                new Lop_dao().updateLop(lop2);
                                request.setAttribute("message", "Lưu thành công!");
                                if (request.getParameter("option2") != null) {
                                    if (!request.getParameter("option2").equals("allKhoa")) {
                                        flag = false;
                                    }

                                }
                                request.setAttribute("message", "Lưu thành công!");
                            }

                        }
                        //thêm lớp
                        if (request.getParameter("addlop") != null) {
                            if (new Lop_dao().isTenLopDuplicate(request.getParameter("lopid_add").toLowerCase())) {
                                request.setAttribute("message", "Lớp đã tồn tại trên hệ thống!");
                            } else {
                                Lop lopt = new Lop();
                                lopt.setId(request.getParameter("lopid_add").toLowerCase());//cần sửa sau này
                                lopt.setTen(request.getParameter("lopid_add").toLowerCase());
                                lopt.setGiangVienID(request.getParameter("gvmoiadd"));
                                lopt.setKhoaID(request.getParameter("khoamoiadd"));
                                lopt.setKhoaHocID(Integer.parseInt(request.getParameter("khoahocmoiadd")));
                                new Lop_dao().addLop(lopt);
                                request.setAttribute("message", "Thêm thành công!");

                            }
                        }
                        //Xóa lớp
                        if (request.getParameter("del") != null) {
                            String del = request.getParameter("del");
                            new Lop_dao().deleteLop_by_ID(del);
                            Lop l = new Lop_dao().getLop_by_ID(del);
                            if (l != null) {
                                request.setAttribute("message", "Không thể xóa lớp đang trong công tác giảng dạy!");
                            }
                        }
                        //lọc select lớp theo khoa
                        if (request.getParameter("khoaId") == null || request.getParameter("khoaId").equals("allKhoa")) {
                            lop = new Lop_dao().getAllLop();
                            request.setAttribute("khoaSelect", "allKhoa");
                        } else {
                            String khoaId = (String) request.getParameter("khoaId");
                            request.setAttribute("khoaSelect", khoaId);
                            lop = new Lop_dao().getLop_by_KhoaID(khoaId);
                        }

                        //Lọc giảng viên theo khoa trong bảng
                        if (request.getParameter("idse") != null) {
                            request.setAttribute("idse", request.getParameter("idse"));
                            dsgv = (ArrayList<Giang_Vien>) new Giang_Vien_dao().getGiangVien_by_KhoaID(request.getParameter("idse"));
                            request.setAttribute("lopse", dsgv);
                            kh = new Khoa_dao().getKhoa_by_ID(request.getParameter("idse"));
                            request.setAttribute("khse", kh);
                            if (request.getParameter("ido") == null) {

                            } else {
                                dsgv2 = (ArrayList<Giang_Vien>) new Giang_Vien_dao().getGiangVien_by_KhoaID(request.getParameter("ido"));
                            }
                            request.setAttribute("lopol", dsgv2);
                        }
                        
                        

                        //giữ nguyên danh sách lớp theo khoa được chọn
                        if (request.getParameter("option") != null) {
                            lop = new Lop_dao().getLop_by_KhoaID(request.getParameter("option"));
                            if (lop == null || lop.isEmpty()) {
                                lop = new Lop_dao().getAllLop();
                            }
                            request.setAttribute("khoaSelect", request.getParameter("option"));
                        }
                        if (flag == false && request.getParameter("option2") != null) {
                            lop = new Lop_dao().getLop_by_KhoaID(request.getParameter("option2"));
                            request.setAttribute("khoaSelect", request.getParameter("option2"));
                        }

                        //reset list
                        if (khList != null) {
                            khList.clear();
                        }
                        if (khoa != null) {
                            khoa.clear();
                        }
                        khList = (ArrayList<Khoa_Hoc>) new Khoa_Hoc_dao().getAllKhoaHoc();
                        khoa = new Khoa_dao().getAllKhoa();
                        lop = new Lop_dao().getLop_by_KhoaID((String)session.getAttribute("username"));
                        return null;
                    });
                     {
                        try {
                            future.get();
                        } catch (InterruptedException | ExecutionException ex) {
                            Logger.getLogger(khoa_lop.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    request.setAttribute("lopList", lop);
                    request.setAttribute("khList", khList);
                    request.setAttribute("khoaList", khoa);
                    
                    if (request.getParameter("wrap") != null) {
                        request.setAttribute("wrap", request.getParameter("wrap"));
                    } 
                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/khoa/khoa_lop.jsp");
                    dispatcher.forward(request, response);

            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InterruptedException | ExecutionException ex) {
            Logger.getLogger(khoa_lop.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
