package com.drl.controller;


import com.drl.daos.DRL_dao;

import com.drl.daos.HK_NK_dao;
import com.drl.daos.Khoa_dao;
import com.drl.daos.Lop_dao;

import com.drl.models.DRL;

import com.drl.models.HK_NK;
import com.drl.models.Khoa;
import com.drl.models.Lop;

import com.drl.tools.ThreadPool;
import java.io.IOException;
import java.net.URLEncoder;

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

@WebServlet(urlPatterns = {"/school_drl"})
public class school_drl extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ArrayList<DRL> drlList = null;
    private ArrayList<Khoa> dskhoa = null;
    private ArrayList<Lop> dsLop = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException, ExecutionException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Kiểm tra đã từng đăng nhập
        HttpSession session = request.getSession(false);
        String username = null;

        if (session != null) {
            username = (String) session.getAttribute("username");
        }

        if (null == username) {
            String message = URLEncoder.encode("Vui lòng đăng nhập!", "UTF-8");
            String link = "/login_alert?message=" + message;
            response.sendRedirect(request.getContextPath() + link);

        } else {
            switch (username) {
                case "": {
                    String message = URLEncoder.encode("Vui lòng đăng nhập!", "UTF-8");
                    String link = "/login_alert?message=" + message;
                    response.sendRedirect(request.getContextPath() + link);
                    break;
                }
                default:
                    if ((int) session.getAttribute("rule") != 1) {
                        response.sendRedirect("login");
                        return;
                    }

                    Future<Void> future = ThreadPool.executorService.submit(() -> {
                        if (request.getParameter("wrapId") != null) {
                            request.setAttribute("wrap", request.getParameter("wrapId"));
                        }
                        if (request.getParameter("idduyet") != null) {
                            DRL drltest = DRL_dao.getDRLOne(request.getParameter("idduyet"), Integer.parseInt(request.getParameter("hk")));
                            if (drltest.getStatus() <4 ) {
                                request.setAttribute("message", "Sinh viên này chưa hoàn tất các cột điểm!");
                            } else {
                                new DRL_dao().updateStatus(5, request.getParameter("idduyet"), Integer.parseInt(request.getParameter("hk")));
                            }
                        }
                        if (request.getParameter("idhuy") != null) {
                            new DRL_dao().updateScoresToZero(request.getParameter("idhuy"), Integer.parseInt(request.getParameter("hk")));
                            request.setAttribute("message", "Hủy bỏ kết quả thành công!");
                        }
                        dskhoa = new Khoa_dao().getAllKhoa();
                        HK_NK xet = new HK_NK_dao().getHK_NKWithXetEqualOne();
                        int hkxet = xet.getId();
                        //lọc theo khoa

                        if (request.getParameter("khoaId") != null) {
                            String khoa = request.getParameter("khoaId");
                            drlList = (ArrayList<DRL>) DRL_dao.getAllDRLWithTotal_Khoa(hkxet, request.getParameter("khoaId"));
                            request.setAttribute("khoaSelect", khoa);
                            dsLop = (ArrayList<Lop>) new Lop_dao().getLop_by_KhoaID(khoa);
                            request.setAttribute("lopSelectList", dsLop);
              
                        }

                        //lọc theo lớp
                        if (request.getParameter("lopId") != null || !request.getParameter("lopId").equals("null")) {
                            String lop = request.getParameter("lopId");
                            drlList = (ArrayList<DRL>) DRL_dao.getAllDRLWithTotal_Lop(hkxet, lop);
                            request.setAttribute("lopSelect", lop);
                            request.setAttribute("khoaSelect", request.getParameter("khoaId"));
               
                        }

                        if (request.getParameter("lopId").equals("null")) {
                            drlList = (ArrayList<DRL>) DRL_dao.getAllDRLWithTotal_Khoa(hkxet, request.getParameter("khoaId"));
                        }

                        return null;
                    });
                     {
                        try {
                            future.get();
                        } catch (InterruptedException | ExecutionException ex) {
                            Logger.getLogger(school_giangvien.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    if (request.getParameter("wrap") != null) {
                        request.setAttribute("wrap", request.getParameter("wrap"));
                    }
                    request.setAttribute("khoaList", dskhoa);
                    request.setAttribute("drlList", drlList);

                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/school/admin_drl.jsp");
                    dispatcher.forward(request, response);

            }

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);

        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(school_drl.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
