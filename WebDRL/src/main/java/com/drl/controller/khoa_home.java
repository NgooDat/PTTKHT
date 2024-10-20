package com.drl.controller;

import com.drl.daos.Khoa_dao;
import com.drl.daos.Lop_dao;
import com.drl.models.Lop;
import com.drl.models.Khoa;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/khoa_home"})
public class khoa_home extends HttpServlet {

	private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //Tạm thời ch lọc theo khóa học
        ArrayList<Lop> lop = new Lop_dao().getAllLop();
        request.setAttribute("lopList", lop);
        
        ArrayList<Khoa> khoa = new Khoa_dao().getAllKhoa();
        request.setAttribute("khoaList", khoa);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/khoa/khoa_home.jsp");
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
