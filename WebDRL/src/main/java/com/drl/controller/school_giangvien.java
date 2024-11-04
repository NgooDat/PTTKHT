package com.drl.controller;

import com.drl.daos.Giang_Vien_dao;
import com.drl.daos.Khoa_dao;
import com.drl.daos.Lop_dao;
import com.drl.daos.Tai_Khoan_dao;
import com.drl.models.Giang_Vien;
import com.drl.models.Khoa;
import com.drl.models.Lop;
import com.drl.models.Tai_Khoan;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.drl.tools.ThreadPool;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/school_giangvien"})
public class school_giangvien extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private List<Lop> lop = null;
    private List<Khoa> khoa = null;
    private List<Giang_Vien> dsGV = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InterruptedException, ExecutionException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Kiểm tra đã từng đăng nhập
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
                    if ((int) session.getAttribute("rule") != 1) {
                        response.sendRedirect("login");
                        return;
                    }

                    Future<Void> future = ThreadPool.executorService.submit(() -> {
                        //khóa
                        if (request.getParameter("lock") != null) {
                            new Tai_Khoan_dao().updateStatusToggle(request.getParameter("lock"));
                            request.setAttribute("message", "Khóa/mở tài khoản thành công!");
                        }
                        //xóa
                        if (request.getParameter("del") != null) {

                            new Giang_Vien_dao().deleteGiangVien_by_ID(request.getParameter("del"));
                            Giang_Vien gvtest = new Giang_Vien_dao().getGiangVien_by_ID(request.getParameter("del"));
                            if (gvtest != null) {
                                request.setAttribute("message", "Không thể xóa giảng viên đang cố vấn cho 1 lớp!");
                            } else {
                                new Tai_Khoan_dao().deleteTaiKhoanByEmail(request.getParameter("del"));
                                request.setAttribute("message", "Xóa thành công!");
                            }
                        }
                        if (request.getParameter("maGV") != null) {
                            String maGV = request.getParameter("maGV");
                            if (new Giang_Vien_dao().isGiangVienIdExists(maGV)) {
                                request.setAttribute("message", "Mã giảng viên đã tồn tại trên hệ thống!");
                            } else {
                                Tai_Khoan tk = new Tai_Khoan();
                                tk.setEmail(maGV);
                                tk.setPassword("123");
                                tk.setRulesID(3);
                                tk.setStatus(1);
                                new Tai_Khoan_dao().addTaiKhoan(tk);
                                int tkid = new Tai_Khoan_dao().getTaiKhoan_by_email(maGV).getId();
                                Giang_Vien g = new Giang_Vien();
                                g.setId(maGV);
                                g.setHoTen(request.getParameter("tenGV"));
                                g.setKhoaID(request.getParameter("khoaGV"));
                                String dateString = "2025-10-18";
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                                Date date = formatter.parse(dateString);
                                g.setNgaySinh(date);
                                g.setSdt("");
                                g.setEmail(maGV+"@gmail.com");
                                g.setDiaChi("");
                                g.setQueQuan("");
                                g.setTaiKhoanID(tkid);

                                new Giang_Vien_dao().addGiangVien(g);

                            }

                        }
                        //Lưu thông tin
                        if (request.getParameter("gv-name") != null) {
                            Giang_Vien gv = new Giang_Vien_dao().getGiangVien_by_ID(request.getParameter("id-save"));
                            if (!request.getParameter("gv-name").equals("")) {
                                gv.setHoTen(request.getParameter("gv-name"));
                            }
                            gv.setKhoaID(request.getParameter("gv-khoa"));
                            new Giang_Vien_dao().updateGiangVien(gv);
                            request.setAttribute("message", "Lưu thành công!");
                        }

                        //lọc cho select khoa
                        if (request.getParameter("khoaId") == null || request.getParameter("khoaId").equals("allKhoa")) {
                            dsGV = (ArrayList<Giang_Vien>) new Giang_Vien_dao().getAllGiangVien();
                            request.setAttribute("khoaSelect", "allKhoa");
                        } else {
                            String khoaId = (String) request.getParameter("khoaId");
                            request.setAttribute("khoaSelect", khoaId);
                            dsGV = (ArrayList<Giang_Vien>) new Giang_Vien_dao().getGiangVien_by_KhoaID(khoaId);
                        }

                        //lọc sau khi xóa sửa balabala
                        if (request.getParameter("opt") != null) {
                            if (request.getParameter("opt").equals("allKhoa")) {
                                dsGV = (ArrayList<Giang_Vien>) new Giang_Vien_dao().getAllGiangVien();
                                request.setAttribute("khoaSelect", "allKhoa");
                            } else {
                                dsGV = (ArrayList<Giang_Vien>) new Giang_Vien_dao().getGiangVien_by_KhoaID(request.getParameter("opt"));
                                request.setAttribute("khoaSelect", request.getParameter("opt"));
                            }
                        }

                        lop = new Lop_dao().getAllLop();
                        khoa = new Khoa_dao().getAllKhoa();

                        return null;
                    });
                     {
                        try {
                            future.get();
                        } catch (InterruptedException | ExecutionException ex) {
                            Logger.getLogger(school_giangvien.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (request.getParameter("wrap") != null) {
                        request.setAttribute("wrap", request.getParameter("wrap"));
                    }
                    request.setAttribute("lopList", lop);
                    request.setAttribute("khoaList", khoa);
                    request.setAttribute("gvList", dsGV);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/school/admin_giangvien.jsp");
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
            Logger.getLogger(school_giangvien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
