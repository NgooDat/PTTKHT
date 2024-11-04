package com.drl.controller;

import com.drl.daos.DBConnect;
import com.drl.daos.Giang_Vien_dao;
import com.drl.daos.Khoa_dao;
import com.drl.daos.Lop_dao;
import com.drl.daos.Sinh_Vien_dao;
import com.drl.daos.Tai_Khoan_dao;
import com.drl.models.Giang_Vien;
import com.drl.models.Lop;
import com.drl.models.Khoa;
import com.drl.models.Sinh_Vien;
import com.drl.models.Tai_Khoan;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.drl.tools.ThreadPool;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

@WebServlet(urlPatterns = {"/school_sinhvien"})
public class school_sinhvien extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private List<Lop> lop = null;
    private List<Khoa> khoa = null;
    private List<Sinh_Vien> dsSV = null;
    private ArrayList<Tai_Khoan> dstk = null;

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
        Connection con = null;

        con = DBConnect.getConnection();
        if (con == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/alert/overload.jsp");
            dispatcher.forward(request, response);
            return;
        }

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
                    Future<Void> future2 = (Future<Void>) ThreadPool.executorService.submit(() -> {
                        

                        //xóa
                        if (request.getParameter("del") != null) {

                            new Sinh_Vien_dao().deleteSinhVien_by_ID(request.getParameter("del"));
                            Sinh_Vien gvtest = new Sinh_Vien_dao().getSinhVienById(request.getParameter("del"));
                            if (gvtest != null) {
                                request.setAttribute("message", "Không thể xóa sinh viên đã có kết quả học tập!");
                            } else {
                                new Tai_Khoan_dao().deleteTaiKhoanByEmail(request.getParameter("del"));
                                request.setAttribute("message", "Xóa thành công!");

                            }

                        }
                        //Lưu thông tin
                        if (request.getParameter("gv-name") != null) {
                            Sinh_Vien gv = new Sinh_Vien_dao().getSinhVienById(request.getParameter("id-save"));
                            if (!request.getParameter("gv-name").equals("")) {
                                gv.setHoTen(request.getParameter("gv-name"));
                            }
                            gv.setLopID(request.getParameter("gv-lop"));
                            new Sinh_Vien_dao().updateSinhVien(gv);
                            Tai_Khoan tkl = null;
                            try {
                                tkl = new Tai_Khoan_dao().getTaiKhoan_by_email(request.getParameter("id-save"));
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(school_sinhvien.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            if (request.getParameter("gv-cv").equals("1")) {
                                tkl.setRulesID(4);
                            } else {
                                tkl.setRulesID(5);
                            }
                            new Tai_Khoan_dao().updateTaiKhoan(tkl);
                            request.setAttribute("message", "Lưu thành công!");

                        }
                        //Thêm
                        if (request.getParameter("msv") != null) {
                            String msv = request.getParameter("msv");
                            if (new Sinh_Vien_dao().isSinhVienIdExists(msv)) {
                                request.setAttribute("message", "Mã sinh viên đã tồn tại trên hệ thống!");
                            } else {

                                Tai_Khoan tk = new Tai_Khoan();
                                tk.setEmail(msv);
                                tk.setPassword("123");
                                if (request.getParameter("chucvu").equals("a")) {
                                    tk.setRulesID(4);
                                } else {
                                    tk.setRulesID(5);
                                }
                                tk.setStatus(1);
                                new Tai_Khoan_dao().addTaiKhoan(tk);

                                int tkid = 0;
                                try {
                                    tkid = new Tai_Khoan_dao().getTaiKhoan_by_email(msv).getId();
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(school_sinhvien.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                Sinh_Vien g = new Sinh_Vien();
                                g.setId(msv);
                                g.setHoTen(request.getParameter("hoten"));
                                g.setLopID(request.getParameter("lopsv"));
                                String dateString = "2025-10-18";
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                                Date date = null;
                                try {
                                    date = formatter.parse(dateString);
                                } catch (ParseException ex) {
                                    Logger.getLogger(school_sinhvien.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                g.setGioiTinh("");
                                g.setNgaySinh(date);
                                g.setSdt("");
                                g.setEmail(msv + "@gmail.com");
                                g.setDiaChi("");
                                g.setQueQuan("");
                                g.setTaiKhoanID(tkid);

                                new Sinh_Vien_dao().addSV(g);

                            }

                        }
                        //khóa
                        if (request.getParameter("lock") != null) {
                            new Tai_Khoan_dao().updateStatusToggle(request.getParameter("lock"));
                            request.setAttribute("message", "Khóa/mở tài khoản thành công!");
                        }
                        dstk = (ArrayList<Tai_Khoan>) new Tai_Khoan_dao().getAllTaiKhoan();
                        khoa = new Khoa_dao().getAllKhoa();
                        lop = new Lop_dao().getAllLop();

                        boolean tg = false;
                        if (request.getParameter("khoaId") != null) {
                            dsSV = (List<Sinh_Vien>) new Sinh_Vien_dao().getSV_by_KhoaID(request.getParameter("khoaId"));
                            request.setAttribute("khoaSelect", request.getParameter("khoaId"));
                            lop = new Lop_dao().getLop_by_KhoaID(request.getParameter("khoaId"));
                            request.setAttribute("lopSelectList", lop);
                            request.setAttribute("lopSelect", "all");
                            request.setAttribute("svList", dsSV);
                            tg = true;
                            if (request.getParameter("lopId").equals("all")) {
                                return;
                            }

                        }

                        if (request.getParameter("lopId") != null) {
                            dsSV = (List<Sinh_Vien>) new Sinh_Vien_dao().getSV_by_LopID(request.getParameter("lopId"));
                            request.setAttribute("khoaSelect", request.getParameter("khoaId"));
                            lop = new Lop_dao().getLop_by_KhoaID(request.getParameter("khoaId"));
                            request.setAttribute("lopSelect", request.getParameter("lopId"));
                            request.setAttribute("lopSelectList", lop);
                            request.setAttribute("svList", dsSV);

                            tg = true;
                        }
                        if (tg == false) {
                            dsSV = new Sinh_Vien_dao().getAllSV();
                            khoa = new Khoa_dao().getAllKhoa();
                        }
                        if (request.getParameter("khoaId").equals("null") && request.getParameter("lopId").equals("null")) {

                            dsSV = new Sinh_Vien_dao().getAllSV();
                        }

                        lop = new Lop_dao().getAllLop();
                        request.setAttribute("lopList", lop);

                    });
                     {
                        try {

                            future2.get();
                        } catch (InterruptedException | ExecutionException ex) {
                            Logger.getLogger(school_giangvien.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (request.getParameter("wrap") != null) {
                        request.setAttribute("wrap", request.getParameter("wrap"));
                    }

                    request.setAttribute("dstk", dstk);
                    request.setAttribute("lopList", lop);
                    request.setAttribute("khoaList", khoa);
                    request.setAttribute("svList", dsSV);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/school/admin_sinhvien.jsp");
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
            Logger.getLogger(school_sinhvien.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
