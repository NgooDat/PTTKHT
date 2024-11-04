
package com.drl.controller;

import com.drl.daos.Giang_Vien_dao;
import com.drl.models.Giang_Vien;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "getGVfromKhoa", urlPatterns = {"/getGiangVienByKhoa"})
public class getGVfromKhoa extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String khoaID = request.getParameter("khoaID");
        ArrayList<Giang_Vien> gvList = (ArrayList<Giang_Vien>) new Giang_Vien_dao().getGiangVien_by_KhoaID(khoaID);
        
        // Chuyển đổi gvList thành JSON
        String json = new Gson().toJson(gvList);
        
        response.setContentType("application/json");
        response.getWriter().write(json);
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
