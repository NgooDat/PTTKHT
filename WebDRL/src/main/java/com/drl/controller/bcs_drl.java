/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.drl.controller;

import com.drl.daos.DBConnect;
import com.drl.daos.DRL_dao;
import com.drl.models.DRL;
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

/**
 *
 * @author Dat
 */
@WebServlet(name = "bcs_drl", urlPatterns = {"/bcs-drl"})
public class bcs_drl extends HttpServlet {
    
    private ArrayList<DRL> dsDRL = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        processRequest(request, response);
        HttpSession session = request.getSession(false); // Không tạo session mới nếu chưa có
        RequestDispatcher dispatcher;
        Connection con = DBConnect.getConnection();
        if (con == null) {
            dispatcher = request.getRequestDispatcher("views/alert/overload.jsp");
            dispatcher.forward(request, response);
            return;
        }
        if (session == null) {
            response.sendRedirect("login");
            return;
        }
        if (session.getAttribute("username") == null) {
            response.sendRedirect("login");
            return;
        }
        if ((int) session.getAttribute("rule") != 4) {
            response.sendRedirect("login");
            return;
        }
        if (request.getParameter("id") == null) {
            response.sendRedirect("bcs-tkb");
            return;
        }
        if (!request.getParameter("id").equals(session.getAttribute("username"))) {
            response.sendRedirect("login");
            return;
        }
        Future<Void> future = (Future<Void>) ThreadPool.executorService.submit(() -> {
            String id = request.getParameter("id");
            dsDRL = (ArrayList<DRL>) new DRL_dao().getDRL_by_SinhVienID_HK(id);
        });
        try {
            future.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(bcs_drl.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("drlList", dsDRL);
        dispatcher = request.getRequestDispatcher("views/bcs/bcs-drl.jsp");
        dispatcher.forward(request, response);
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
