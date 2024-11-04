/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.drl.controller;

import com.drl.daos.DBConnect;
import com.drl.daos.DRL_dao;
import com.drl.daos.Giang_Vien_dao;
import com.drl.daos.HK_NK_dao;
import com.drl.daos.Lop_dao;
import com.drl.daos.Sinh_Vien_dao;
import com.drl.daos.Thong_Bao_dao;
import com.drl.models.DRL;
import com.drl.models.Giang_Vien;
import com.drl.models.HK_NK;
import com.drl.models.Lop;
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
@WebServlet(name = "gv_lop", urlPatterns = {"/gv-lop"})
public class gv_lop extends HttpServlet {
    
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
        if ((int) session.getAttribute("rule") != 3) {
            response.sendRedirect("login");
            return;
        }
        if (request.getParameter("id") == null) {
            response.sendRedirect("gv-tkb");
            return;
        }
        
        Future<Void> future;
        future = (Future<Void>) ThreadPool.executorService.submit(() -> {
        	 HK_NK tehk = new HK_NK_dao().getHK_NKWithXetEqualOne();
             tb = new Thong_Bao_dao().getThongBaoByHK_NKID(tehk.getId());
             request.setAttribute("thongbao", tb);
        	ArrayList<Lop> dsLopAll = (ArrayList<Lop>) new Lop_dao().getAllLop();
        	ArrayList<DRL> drl = new ArrayList<>();
        	dsDRL = new ArrayList<>();
        	for(Lop lop: dsLopAll) {
        		if(lop.getGiangVienID().equals(request.getParameter("id"))){
        			new DRL_dao();
					try {
						drl = (ArrayList<DRL>) DRL_dao.getAllDRLWithTotal_Lop(tehk.getId(), lop.getId());
					} catch (InterruptedException | ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
        			dsDRL.addAll(drl);
        		}
        	}

        });
        try {
            future.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(bcs_drl.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("drlList", dsDRL);
        dispatcher = request.getRequestDispatcher("views/gv/gv_lop.jsp");
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
