/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.drl.controller;

import com.drl.daos.DBConnect;
import com.drl.daos.DRL_dao;
import com.drl.daos.HK_NK_dao;
import com.drl.daos.Sinh_Vien_dao;
import com.drl.daos.Thong_Bao_dao;
import com.drl.models.DRL;
import com.drl.models.HK_NK;
import com.drl.models.Sinh_Vien;
import com.drl.models.Thong_Bao;
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
@WebServlet(name = "bcs_lop", urlPatterns = {"/bcs-lop"})
public class bcs_lop extends HttpServlet {
    
    private ArrayList<DRL> dsDRL = null;
    private Thong_Bao tb = null;

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
        Sinh_Vien tesv = new Sinh_Vien_dao().getSinhVienById((String)session.getAttribute("username"));
        if (!tesv.getLopID().equals(request.getParameter("id"))) {
            response.sendRedirect("login");
            return;
        }
        Future<Void> future;
        future = (Future<Void>) ThreadPool.executorService.submit(() -> {
            HK_NK tehk = new HK_NK_dao().getHK_NKWithXetEqualOne();
            tb = new Thong_Bao_dao().getThongBaoByHK_NKID(tehk.getId());
            request.setAttribute("thongbao", tb);
            String id = request.getParameter("id");
            try {
                dsDRL = (ArrayList<DRL>) DRL_dao.getAllDRLWithTotal_Lop(tehk.getId(), id);
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(bcs_lop.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        try {
            future.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(bcs_drl.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("drlList", dsDRL);
        dispatcher = request.getRequestDispatcher("views/bcs/bcs_lop.jsp");
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
