package com.drl.controller;

import com.drl.daos.DBConnect;
import com.drl.daos.Khoa_dao;
import com.drl.models.Khoa;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.ArrayList;
import com.drl.tools.ThreadPool;
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
        //Kiểm tra đã từng đăng nhập
        Connection con = new DBConnect().getConnection();
        if(con == null){
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
            response.sendRedirect(request.getContextPath() + link );

        } 
        else switch (username) {
            case "":
                {
                    String message = URLEncoder.encode("Vui lòng đăng nhập!", "UTF-8");
                    String link = "/login_alert?message=" + message;
                    response.sendRedirect(request.getContextPath() + link );
                    break;
                }
            default:
                if((int)session.getAttribute("rule") != 1){
                    response.sendRedirect("login");
                    return;
                }

            	Future<Void> future = ThreadPool.executorService.submit(() -> {
                    khoa = new Khoa_dao().getAllKhoa();
                    return null; 
                });
                future.get();
                request.setAttribute("khoaList", khoa);
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/school/admin_khoa.jsp");
                        dispatcher.forward(request, response);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InterruptedException | ExecutionException ex) {
            Logger.getLogger(school_khoa.class.getName()).log(Level.SEVERE, null, ex);
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
