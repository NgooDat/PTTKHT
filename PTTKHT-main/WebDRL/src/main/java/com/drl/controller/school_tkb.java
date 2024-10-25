package com.drl.controller;

import com.drl.daos.DBConnect;
import com.drl.daos.HK_NK_dao;
import com.drl.daos.Khoa_Hoc_dao;

import com.drl.models.HK_NK;
import com.drl.models.Khoa_Hoc;

//import com.drl.models.Thong_Bao;
import com.drl.tools.ThreadPool;
import java.io.IOException;
import java.sql.Connection;
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

@WebServlet(urlPatterns = {"/school_tkb"})
public class school_tkb extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ArrayList<Khoa_Hoc> khoahoc = null;
    private ArrayList<HK_NK> hocky = null;
    //private ArrayList<Thong_Bao> tb = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InterruptedException, ExecutionException {
        response.setContentType("text/html;charset=UTF-8");
        Connection con = new DBConnect().getConnection();
        if(con == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/alert/overload.jsp");
            dispatcher.forward(request, response);
            return;
        }
        //Kiểm tra đã từng đăng nhập
        HttpSession session = request.getSession(false);
        String username = null;

        if (session != null) {
            username = (String) session.getAttribute("username");
        }

        if (username == null || username.equals("")) {
            String message = "Vui lòng đăng nhập!";
            request.setAttribute("message", message);
            response.sendRedirect("login");

        } else {
            if((int)session.getAttribute("rule") != 1){
                response.sendRedirect("login");
                return;
            }
            Future<Void> future = ThreadPool.executorService.submit(() -> {
                khoahoc = (ArrayList<Khoa_Hoc>) new Khoa_Hoc_dao().getAllKhoaHoc();
                return null; 
            });
            Future<Void> future2 = ThreadPool.executorService.submit(() -> {
                hocky = (ArrayList<HK_NK>) new HK_NK_dao().getAllHK_NK();
                return null; 
            });
            Future<Void> future3 = ThreadPool.executorService.submit(() -> {
                //dsSV = (ArrayList<Sinh_Vien>) Sinh_Vien_dao.getAllSV();
                return null; 
            });
            future.get();
            future2.get();
            future3.get();
            request.setAttribute("khoaHocList", khoahoc);
            request.setAttribute("hkNkList", hocky);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/school/admin_tkb.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InterruptedException | ExecutionException ex) {
            Logger.getLogger(school_tkb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InterruptedException | ExecutionException ex) {
            Logger.getLogger(school_tkb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
