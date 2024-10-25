package com.drl.controller;

import com.drl.daos.DBConnect;
import com.drl.daos.Khoa_dao;
import com.drl.daos.Lop_dao;
import com.drl.daos.Sinh_Vien_dao;
import com.drl.models.Lop;
import com.drl.models.Khoa;
import com.drl.models.Sinh_Vien;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.drl.tools.ThreadPool;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/school_sinhvien"})
public class school_sinhvien extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private List<Lop> lop = null;
    private List<Khoa> khoa = null;
    private List<Sinh_Vien> dsSV = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InterruptedException, ExecutionException {
        response.setContentType("text/html;charset=UTF-8");
        //Kiểm tra đã từng đăng nhập
        HttpSession session = request.getSession(false);
        String username = null;
        Connection con = new DBConnect().getConnection();
        if(con == null){
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/alert/overload.jsp");
            dispatcher.forward(request, response);
            return;
        }

        if (session != null) {
            username = (String) session.getAttribute("username");
        }

        if (null == username) {
            String message = URLEncoder.encode("Vui lòng đăng nhập!", "UTF-8");
            String link = "/login_alert?message=" + message;
            response.sendRedirect(request.getContextPath() + link );

        } 
        else switch (username) {
            case "":
                {
                    String message = URLEncoder.encode("Vui lòng đăng nhập!", "UTF-8");
                    String link = "/login_alert?message=" + message;
                    response.sendRedirect(request.getContextPath() + link );
                    break;
                }
            default:
                if((int)session.getAttribute("rule") != 1){
                    response.sendRedirect("login");
                    return;
                }
            	Future<Void> future = ThreadPool.executorService.submit(() -> {
                    lop = new Lop_dao().getAllLop(); 

                    return null; 
                });
                Future<Void> future2 = ThreadPool.executorService.submit(() -> {
                    khoa = new Khoa_dao().getAllKhoa();
                    return null; 
                });
                Future<Void> future3 = ThreadPool.executorService.submit(() -> {
                    dsSV = (ArrayList<Sinh_Vien>) new Sinh_Vien_dao().getAllSV();
                    return null; 
                });
                future.get();
                future2.get();
                future3.get();
                request.setAttribute("lopList", lop);
                request.setAttribute("khoaList", khoa);
                request.setAttribute("svList", dsSV);
                RequestDispatcher dispatcher = request.getRequestDispatcher("views/school/admin_sinhvien.jsp");
                        dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InterruptedException | ExecutionException ex) {
            Logger.getLogger(school_sinhvien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InterruptedException | ExecutionException ex) {
            Logger.getLogger(school_sinhvien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
