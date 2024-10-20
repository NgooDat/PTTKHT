package com.drl.controller;

import com.drl.daos.Tai_Khoan_dao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/ktra_dangnhap"})
public class ktra_dangnhap extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //Kiểm tra nếu người dùng không nhập gì??
        if(username.equals("") || password.equals("")){
            String message = "Vui lòng nhập đầy đủ thông tin!";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/login/login.jsp");
            dispatcher.forward(request, response);
        }
        boolean check = new Tai_Khoan_dao().checkLogin(username, password);
        if(check){
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("school_home");
        }else{
            //đưa ra thông báo
            String message = "Tên đăng nhập hoặc mật khẩu không đúng!";
            request.setAttribute("message", message);
            request.setAttribute("password", password);
            request.setAttribute("username", username);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/login/login.jsp");
            dispatcher.forward(request, response);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
