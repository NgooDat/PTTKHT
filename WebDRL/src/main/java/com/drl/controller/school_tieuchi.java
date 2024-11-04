package com.drl.controller;

import com.drl.daos.DBConnect;
import com.drl.daos.DRL_dao;

import com.drl.daos.Tieu_Chi_dao;

import com.drl.models.Tieu_Chi;
import com.drl.tools.ThreadPool;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

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

@WebServlet(urlPatterns = {"/school_tieuchi"})
public class school_tieuchi extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ArrayList<Tieu_Chi> tieuChi = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InterruptedException, ExecutionException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
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
                    if (request.getParameter("iddel") != null) {
                        String iddel = request.getParameter("iddel");
                        if (iddel.equals("add-tieu-chi")) {
                            Tieu_Chi newtc = new Tieu_Chi();
                            newtc.setNoiDung("Chỉnh sửa nội dung tại đây");
                            newtc.setTongDiem(0);
                            new Tieu_Chi_dao().addTieuChi(newtc);
                        } else {
                            new Tieu_Chi_dao().deleteTieuChi(Integer.parseInt(iddel));
                            Tieu_Chi tcc = new Tieu_Chi_dao().getTieuChi_by_id(Integer.parseInt(request.getParameter("iddel")));
                            if(tcc!=null){
                                request.setAttribute("message", "Tiêu chí đã được triển khai chấm điểm trên hệ thống!");
                            }
                            else request.setAttribute("message", "Xóa tiêu chí đánh giá thành công!");
                        }
                    }
                    if (request.getParameter("iddadd") != null) {
                        Tieu_Chi tc = new Tieu_Chi_dao().getTieuChi_by_id(Integer.parseInt(request.getParameter("iddadd")));
                        tc.setNoiDung(request.getParameter("noidung"));
                        tc.setTongDiem(Integer.parseInt(request.getParameter("diem")));
                        new Tieu_Chi_dao().updateTieuChi(tc);
                        request.setAttribute("message", "Lưu tiêu chí đánh giá thành công!");
                        //thêm tieu chi vào đrl
                
                    }



                    if (tieuChi != null) {
                        tieuChi.clear();
                    }
                    Future<Void> future = ThreadPool.executorService.submit(() -> {
                        tieuChi = (ArrayList<Tieu_Chi>) new Tieu_Chi_dao().getAllTieuChi();
                        return null;
                    });
                     {
                        try {
                            future.get();
                        } catch (InterruptedException | ExecutionException ex) {
                            Logger.getLogger(school_khoa.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                    request.setAttribute("tieuChi", tieuChi);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/school/admin_tieuchi.jsp");
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
            Logger.getLogger(school_tieuchi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
