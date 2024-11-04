/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.drl.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dat
 */
@WebServlet(name = "ktraCode", urlPatterns = {"/ktracode"})
public class ktraCode extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("mail") == null) {
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

        String code = (String) session.getAttribute("code");
        String input_code = (String) request.getParameter("code-input");
        if (code.equals(input_code)) {
            session.setAttribute("allow", "allow");
            request.setAttribute("allow", "allow");
            request.setAttribute("mail", request.getParameter("mail"));
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/login/reset_pass.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("message", "Mã code không chính xác!");
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/login/input_code.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
