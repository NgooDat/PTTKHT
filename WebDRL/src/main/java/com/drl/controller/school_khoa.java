package com.drl.controller;
import com.drl.daos.DBConnect;
import com.drl.daos.Khoa_dao;
import com.drl.daos.Tai_Khoan_dao;
import com.drl.models.Khoa;
import com.drl.models.Tai_Khoan;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.ArrayList;
import com.drl.tools.ThreadPool;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@WebServlet(urlPatterns = {"/school_khoa"})
public class school_khoa extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ArrayList<Khoa> khoa = null;

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
                    if ((int) session.getAttribute("rule") != 1) {
                        response.sendRedirect("login");
                        return;
                    }

                    //nút xóa
                    if (request.getParameter("iddel") != null) {
                        String iddel = request.getParameter("iddel");

                        new Khoa_dao().deleteKhoa(iddel);
                        Khoa kh = new Khoa_dao().getKhoa_by_ID(iddel);
                        if (kh != null) {
                            request.setAttribute("message", "Không thể xóa khoa đang trong công tác giảng dạy!");

                        } else {
                            new Tai_Khoan_dao().deleteTaiKhoanByEmail(iddel);
                            request.setAttribute("message", "Xóa thành công!");
                        }
                    }
                    //nút khóa tài khoản
                    if (request.getParameter("idlock") != null) {
                        String idlock = request.getParameter("idlock");
                        new Tai_Khoan_dao().updateStatusToggle(idlock);
                        request.setAttribute("message", "Khóa / mở tài khoản thành công!");
                    }
                    //nút lưu
                    if (request.getParameter("ten-khoa") != null && request.getParameter("ngaytl") != null) {
                        String khoaa = request.getParameter("idkhoa");
                        Khoa kh = new Khoa_dao().getKhoa_by_ID(khoaa);
                        if(!request.getParameter("ten-khoa").equals("")){
                            kh.setTen(request.getParameter("ten-khoa"));
                        }
                        
                        String dateString = request.getParameter("ngaytl");
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        Date date = null;
                        try {
                            date = formatter.parse(dateString);
                        } catch (ParseException ex) {
                            Logger.getLogger(school_khoa.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        kh.setNgayTL(date);
                        new Khoa_dao().updateKhoa(kh);
                        request.setAttribute("message", "Cập nhật thành công!");
                    }
                    //nút thêm
                    if (request.getParameter("ma-khoa-save") != null
                            && request.getParameter("ten-khoa-save") != null
                            && request.getParameter("ngaytl-save") != null) {
                        if (new Khoa_dao().isKhoaExist(request.getParameter("ma-khoa-save").toLowerCase())) {
                            request.setAttribute("message", "Mã khoa đã tồn tại trên hệ thống!");

                        } else {
                            //Thêm tài khoản
                            Tai_Khoan tk = new Tai_Khoan();
                            tk.setEmail(request.getParameter("ma-khoa-save"));
                            tk.setPassword("123");
                            tk.setRulesID(2);
                            tk.setStatus(1);
                            new Tai_Khoan_dao().addTaiKhoan(tk);

                            //Thêm khoa
                            Khoa kh = new Khoa();
                            kh.setId(request.getParameter("ma-khoa-save").toLowerCase());
                            
                            kh.setTen(request.getParameter("ten-khoa-save"));
                            String dateString = request.getParameter("ngaytl-save");
                            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                            Date date = null;
                            try {
                                date = formatter.parse(dateString);
                            } catch (ParseException ex) {
                                Logger.getLogger(school_khoa.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            kh.setNgayTL(date);
                            kh.setStatus(1);
                            new Khoa_dao().addKhoa(kh);
                            request.setAttribute("message", "Thêm thành công!");
                        }

                    }
                    if (khoa != null) {
                        khoa.clear();
                    }
                    Future<Void> future = ThreadPool.executorService.submit(() -> {
                        khoa = new Khoa_dao().getAllKhoa();
                        return null;
                    });
                     {
                        try {
                            future.get();
                        } catch (InterruptedException | ExecutionException ex) {
                            Logger.getLogger(school_khoa.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    request.setAttribute("khoaList", khoa);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/school/admin_khoa.jsp");
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
            Logger.getLogger(school_khoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
