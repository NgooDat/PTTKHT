package com.drl.controller;


import com.drl.daos.Giang_Vien_dao;
import com.drl.daos.Khoa_dao;
import com.drl.models.Giang_Vien;
import com.drl.models.Khoa;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/khoa_giangvien"})
public class khoa_giangvien extends HttpServlet {

	private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ArrayList<Khoa> khoa = new Khoa_dao().getAllKhoa();
        request.setAttribute("khoaList", khoa);

        ArrayList<Giang_Vien> gvList = (ArrayList<Giang_Vien>) new Giang_Vien_dao().getAllGiangVien();
        request.setAttribute("gvList", gvList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/khoa/khoa_giangvien.jsp");
        dispatcher.forward(request, response);
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
