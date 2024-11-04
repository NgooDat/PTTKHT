package com.drl.controller;

import com.drl.daos.DBConnect;

import com.drl.daos.Lop_dao;
import com.drl.daos.Sinh_Vien_dao;
import com.drl.daos.Tai_Khoan_dao;

import com.drl.models.Lop;
import com.drl.models.Sinh_Vien;
import com.drl.models.Tai_Khoan;
import java.io.IOException;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "sv-home", urlPatterns = {"/sv-home"})
public class sv_home extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

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
        if(session.getAttribute("username")==null){
            response.sendRedirect("login");
            return;
        }
        if((int)session.getAttribute("rule")!=5){
            response.sendRedirect("login");
            return;
        }
        if(request.getParameter("id")==null){
            response.sendRedirect("sv-tkb");
            return;
        }
        if(!request.getParameter("id").equals(session.getAttribute("username"))){
            response.sendRedirect("login");
            return;
        }
        
        String id = request.getParameter("id");
        Sinh_Vien sv = new Sinh_Vien_dao().getSinhVienById(id);
        request.setAttribute("sv", sv);
        dispatcher = request.getRequestDispatcher("views/sv/updatesv.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String id = "";
        if (request.getParameter("idaccount") != null) {
            try {
                Sinh_Vien gv = new Sinh_Vien_dao().getSinhVienById(request.getParameter("idaccount"));
                id = request.getParameter("idaccount");
                Tai_Khoan tk = new Tai_Khoan_dao().getTaiKhoan_by_email(request.getParameter("idaccount"));
                if (!request.getParameter("hoTen").equals("")) {
                    gv.setHoTen(request.getParameter("hoTen"));
                }
                if (!request.getParameter("sex").equals("")) {
                    if (request.getParameter("sex").equals("1")) {
                        gv.setGioiTinh("Nam");
                    } else {
                        gv.setGioiTinh("Nữ");
                    }

                }
                if (!request.getParameter("birth").equals("")) {
                    String dateString = request.getParameter("birth");
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = formatter.parse(dateString);
                    gv.setNgaySinh(date);
                }
                if (!request.getParameter("phone").equals("")) {
                    gv.setSdt(request.getParameter("phone"));
                }
                if (!request.getParameter("pass").equals("")) {
                    tk.setPassword(request.getParameter("pass"));
                }
                if (!request.getParameter("add").equals("")) {
                    gv.setDiaChi(request.getParameter("add"));
                }
                if (!request.getParameter("add2").equals("")) {
                    gv.setQueQuan(request.getParameter("add2"));
                }
                new Tai_Khoan_dao().updateTaiKhoan(tk);
                new Sinh_Vien_dao().updateSinhVien(gv);
                request.setAttribute("message", "Cập nhật thành công!");
            } catch (ClassNotFoundException | ParseException ex) {
                Logger.getLogger(updateGV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        response.sendRedirect("sv-home?id=" + id);
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
