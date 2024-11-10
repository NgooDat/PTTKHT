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

@WebServlet(name = "updateSV", urlPatterns = {"/updatesv"})
public class updateSV extends HttpServlet {

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
        if(request.getParameter("id")==null){
            response.sendRedirect("login");
            return;
        }
        switch ((int) session.getAttribute("rule")) {
            case 1:
                Sinh_Vien g = new Sinh_Vien_dao().getSinhVienById((String) request.getParameter("id"));
                request.setAttribute("sv", g);
                dispatcher = request.getRequestDispatcher("views/school/updatesv.jsp");
                dispatcher.forward(request, response);
                break;
            case 2:
                if (request.getAttribute("id") != null) {
                    Sinh_Vien gv = new Sinh_Vien_dao().getSinhVienById((String) request.getParameter("id"));
                    Lop lop = new Lop_dao().getLop_by_ID(gv.getLopID());
                    if (!lop.getKhoaID().equals((String) session.getAttribute("username"))) {
                        response.sendRedirect("login");

                    } else {
                        request.setAttribute("sv", gv);
                        dispatcher = request.getRequestDispatcher("views/school/updatesv.jsp");
                        dispatcher.forward(request, response);
                    }
                } else {
                    response.sendRedirect("login");
                }
                break;
            case 3:
                response.sendRedirect("login");
                break;
            case 4:
                if (request.getAttribute("id") != null) {
                    if (!request.getAttribute("id").equals((String) session.getAttribute("username"))) {
                        response.sendRedirect("login");
                    } else {
                        Sinh_Vien gh = new Sinh_Vien_dao().getSinhVienById((String) request.getAttribute("id"));
                        request.setAttribute("sv", gh);
                        dispatcher = request.getRequestDispatcher("views/school/updatesv.jsp");
                        dispatcher.forward(request, response);
                    }
                } else {
                    response.sendRedirect("login");
                }
                break;
            default:
                if (request.getAttribute("id") != null) {
                    if (!request.getAttribute("id").equals((String) session.getAttribute("username"))) {
                        response.sendRedirect("login");
                    } else {
                        Sinh_Vien gh = new Sinh_Vien_dao().getSinhVienById((String) request.getAttribute("id"));
                        request.setAttribute("sv", gh);
                        dispatcher = request.getRequestDispatcher("views/school/updatesv.jsp");
                        dispatcher.forward(request, response);
                    }
                } else {
                    response.sendRedirect("login");
                }
                break;
        }
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

            } catch (ClassNotFoundException | ParseException ex) {
                Logger.getLogger(updateGV.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        HttpSession session = request.getSession(false); // Không tạo session mới nếu chưa có
        if((int)session.getAttribute("rule")==4 ){
             session.setAttribute("name", request.getParameter("hoTen"));
            response.sendRedirect("bcs-home?id=" + id);
           
        }else{
            response.sendRedirect("updatesv?id=" + id);
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
