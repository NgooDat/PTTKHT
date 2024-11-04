package com.drl.controller;

import com.drl.daos.Tai_Khoan_dao;
import com.drl.models.Tai_Khoan;
import com.drl.tools.Algorithm;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/reset-pass"})
public class reset_pass extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if (request.getParameter("mail") == null || request.getParameter("mail").equals((String)session.getAttribute("mail"))) {
            response.sendRedirect("login");
            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session.getAttribute("allow") != null) {
            if (!request.getParameter("pass1").equals(request.getParameter("pass2"))) {
                request.setAttribute("message", "Mật khẩu không khớp!");
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/login/reset_pass.jsp");
                dispatcher.forward(request, response);
            } else {
                String mail = (String) session.getAttribute("mail");
                String id = Algorithm.getUsernameFromEmail(mail);

                Tai_Khoan tk = null;
                try {
                    tk = new Tai_Khoan_dao().getTaiKhoan_by_email(id);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(reset_pass.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (tk != null) {
                    tk.setPassword(request.getParameter("pass1"));
                    new Tai_Khoan_dao().updateTaiKhoan(tk);
                    session = request.getSession(false);
                    session.invalidate();

                }
                response.sendRedirect("yesss");
            }
        } else {
            response.sendRedirect("login");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
