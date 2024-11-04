package com.drl.controller;

import com.drl.tools.Email;
import com.drl.tools.ThreadPool;
import java.io.IOException;
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

@WebServlet(urlPatterns = {"/input_code"})
public class input_code extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("mail") == null) {
            response.sendRedirect("login");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("mail") == null) {
            response.sendRedirect("login");
            return;
        }
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        if (request.getParameter("mail") == null) {
            response.sendRedirect("login");
            return;
        }
        String code = Email.getRandomCode();
        String mail = request.getParameter("mail");
        ThreadPool.executorService.submit(() -> {
            HttpSession session = request.getSession(false);
            session.setAttribute("mail", mail);
            session.setAttribute("code", code);
            Email.sendEmail(mail, code);
        });

        request.setAttribute("code", code);
        request.setAttribute("mail", mail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/login/input_code.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
