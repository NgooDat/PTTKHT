package com.drl.controller;

import com.drl.daos.DBConnect;
import java.io.IOException;
import java.sql.Connection;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "mainController", urlPatterns = {"/login"})
public class mainController_1 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InterruptedException, ExecutionException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false); // Không tạo session mới nếu chưa có
        

        Connection con = new DBConnect().getConnection();
        if(con == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/alert/overload.jsp");
            dispatcher.forward(request, response);
            return;
        }
        String username = null;
        if (session != null) {
            username = (String) session.getAttribute("username");
        }

        if (username == null || username.equals("")) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/login/login.jsp");
            dispatcher.forward(request, response);
        } else {
            switch ((int)session.getAttribute("rule")) {
                    case 1:
                        session.setAttribute("rule", 1);
                        response.sendRedirect("school_home");
                        return;
                    case 2:
                        session.setAttribute("rule", 2);
                        response.sendRedirect("khoa_home");
                        return;
                    case 3:
                        session.setAttribute("rule", 3);
                        response.sendRedirect("cv_home");
                        return;
                    case 4:
                        session.setAttribute("rule", 4);
                        response.sendRedirect("bcs_home");
                        return;
                    default:
                        session.setAttribute("rule",5);
                        response.sendRedirect("sv_home");
                        return;
                }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InterruptedException | ExecutionException ex) {
            Logger.getLogger(mainController_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InterruptedException | ExecutionException ex) {
            Logger.getLogger(mainController_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}