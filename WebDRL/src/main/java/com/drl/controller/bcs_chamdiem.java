package com.drl.controller;

import com.drl.daos.DBConnect;
import com.drl.daos.DRL_dao;
import com.drl.daos.HK_NK_dao;
import com.drl.daos.Sinh_Vien_dao;
import com.drl.models.DRL;
import com.drl.models.HK_NK;
import com.drl.models.Sinh_Vien;
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

@WebServlet(name = "bcs_chamdiem", urlPatterns = {"/bcs-chamdiem"})
public class bcs_chamdiem extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
        if (request.getParameter("idlop") == null) {
            response.sendRedirect("gv-tkb");
            return;
        }
        
        Future<Void> future;
        Future<Void> submit = (Future<Void>) ThreadPool.executorService.submit(new Runnable() {
            @Override
            public void run() {
                String id = request.getParameter("id");
                request.setAttribute("id", id);
                HK_NK hkk = new HK_NK_dao().getHK_NKWithXetEqualOne();
                dsDRL = (ArrayList<DRL>) new DRL_dao().getAllDRL_SV_HK(id, hkk.getId());
                if (request.getParameter("iddsave") != null) {
                    for (int i = 0; i < dsDRL.size(); i++) {
                        DRL k = new DRL();
                        k = dsDRL.get(i);
                        String s = Integer.toString(k.getId());
                        String rs = request.getParameter(s);
                        int diem = Integer.parseInt(rs);
                        k.setDiemSV(diem);
                        new DRL_dao().updateDiemCS(k.getId(), diem);
                        new DRL_dao().updateStatus(3, id, hkk.getId());
                        request.setAttribute("message", "Đánh giá thành công!");
                    }
                }
                dsDRL = (ArrayList<DRL>) new DRL_dao().getAllDRL_SV_HK(id, hkk.getId());
            }
        });
		future = submit;
        try {
            future.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(bcs_drl.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("drlList", dsDRL);
        dispatcher = request.getRequestDispatcher("views/bcs/bcs_chamdiem.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        processRequest(request, response);
        RequestDispatcher dispatcher;
        Future<Void> future;
        future = (Future<Void>) ThreadPool.executorService.submit(new Runnable() {
            @Override
            public void run() {
                String id = request.getParameter("id");
                request.setAttribute("id", id);
                HK_NK hkk = new HK_NK_dao().getHK_NKWithXetEqualOne();
                dsDRL = (ArrayList<DRL>) new DRL_dao().getAllDRL_SV_HK(id, hkk.getId());
                if (dsDRL != null && !dsDRL.isEmpty()) {
                    if (dsDRL.get(0).getStatus() == 5) {
                        request.setAttribute("message", "Bảng điểm của bạn đã duyệt!");
                    } else {
                        if (request.getParameter("iddsave") != null) {
                            for (int i = 0; i < dsDRL.size(); i++) {
                                DRL k = new DRL();
                                k = dsDRL.get(i);
                                String s = Integer.toString(k.getId());
                                String rs = request.getParameter(s);
                                int diem = Integer.parseInt(rs);
                                k.setDiemSV(diem);
                                k.setStatus(3);
                                new DRL_dao().updateDiemCS(k.getId(), diem);
                                new DRL_dao().updateStatus(3, k.getSinhVienID(), hkk.getId());

                            }
                        }
                    }
                }

                dsDRL = (ArrayList<DRL>) new DRL_dao().getAllDRL_SV_HK(id, hkk.getId());
            }
        });
        try {
            future.get();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(bcs_drl.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("drlList", dsDRL);
        dispatcher = request.getRequestDispatcher("views/bcs/bcs_chamdiem.jsp");
        dispatcher.forward(request, response);
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
