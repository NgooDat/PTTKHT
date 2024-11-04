package com.drl.controller;

import com.drl.daos.DBConnect;
import com.drl.daos.DRL_dao;
import com.drl.daos.HK_NK_dao;
import com.drl.daos.Khoa_Hoc_dao;
import com.drl.daos.Thong_Bao_dao;

import com.drl.models.HK_NK;
import com.drl.models.Khoa_Hoc;
import com.drl.models.Thong_Bao;

//import com.drl.models.Thong_Bao;
import com.drl.tools.ThreadPool;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
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

@WebServlet(urlPatterns = {"/gv-tkb"})
public class gv_tkb extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ArrayList<Khoa_Hoc> khoahoc = null;
    private ArrayList<HK_NK> hocky = null;
    private HK_NK hk = null;
    private Thong_Bao tb = null;
    //private ArrayList<Thong_Bao> tb = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InterruptedException, ExecutionException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        Connection con = DBConnect.getConnection();
        if (con == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/alert/overload.jsp");
            dispatcher.forward(request, response);
            return;
        }
        //Kiểm tra đã từng đăng nhập
        HttpSession session = request.getSession(false);
        String username = null;

        if (session != null) {
            username = (String) session.getAttribute("username");
        }

        if (username == null || username.equals("")) {
            String message = "Vui lòng đăng nhập!";
            request.setAttribute("message", message);
            response.sendRedirect("login");

        } else {
            if ((int) session.getAttribute("rule") != 3) {
                response.sendRedirect("login");
                return;
            }
            Future<Void> future = ThreadPool.executorService.submit(() -> {

                if (request.getParameter("hk") != null) {
                    int up = Integer.parseInt((request.getParameter("hk")));
                    new HK_NK_dao().updateHK_NK(up);
                    Thread.sleep(1000);
                }

                HK_NK x = new HK_NK_dao().getHK_NKWithXetEqualOne();
                tb = new Thong_Bao_dao().getThongBaoByHK_NKID(x.getId());
                khoahoc = (ArrayList<Khoa_Hoc>) new Khoa_Hoc_dao().getAllKhoaHoc();
                Collections.reverse(khoahoc); // Đảo ngược danh sách

                hocky = (ArrayList<HK_NK>) new HK_NK_dao().getAllHK_NK();
                hk = new HK_NK_dao().getHK_NKWithXetEqualOne();
                return null;

            });
            future.get();
            request.setAttribute("khoaHocList", khoahoc);
            request.setAttribute("hkNkList", hocky);
            request.setAttribute("thongbao", tb);
            request.setAttribute("hkNk", hk);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/gv/gv_tkb.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("kh") != null) {


            Khoa_Hoc kh = new Khoa_Hoc_dao().getAllKhoaHoc().getLast();
            int year = LocalDate.now().getYear();
            if ((kh.getNamBD()) > year) {

                request.setAttribute("check", true);
                request.setAttribute("show", "Khóa học mới của năm nay đã được thêm!");
            } else {
                //Thêm khóa học
                kh.setNamBD(kh.getNamBD()+1);
                kh.setNamKT(kh.getNamKT()+1);
                new Khoa_Hoc_dao().addKhoaHoc(kh);
                
                HK_NK temp = new HK_NK();
                temp.setHocKy(1);
                temp.setNienKhoa(kh.getNamBD()+"-"+(kh.getNamBD()+1));
                temp.setXet(0);
                new HK_NK_dao().addHK_NK(temp);
                temp = new HK_NK_dao().getHK_NKByHocKyAndNienKhoa(temp.getHocKy(), temp.getNienKhoa());
                new DRL_dao().addDRLwithHK(temp);

                temp.setHocKy(2);
                temp.setNienKhoa(kh.getNamBD()+"-"+(kh.getNamBD()+1));
                temp.setXet(0);
                new HK_NK_dao().addHK_NK(temp);
                temp = new HK_NK_dao().getHK_NKByHocKyAndNienKhoa(temp.getHocKy(), temp.getNienKhoa());
                new DRL_dao().addDRLwithHK(temp);
                request.setAttribute("check", true);
                request.setAttribute("show", "Thêm thành công!");
            }
            

        } else {
            request.setAttribute("check", false);
            request.setAttribute("show", "a");
        }

        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InterruptedException | ExecutionException | SQLException ex) {
            Logger.getLogger(school_tkb.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = DBConnect.getConnection();
        if (con == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/alert/overload.jsp");
            dispatcher.forward(request, response);
            return;
        }
        //Kiểm tra đã từng đăng nhập
        HttpSession session = request.getSession(false);
        String username = null;

        if (session != null) {
            username = (String) session.getAttribute("username");
        }

        if (username == null || username.equals("")) {
            String message = "Vui lòng đăng nhập!";
            request.setAttribute("message", message);
            response.sendRedirect("login");

        } else {
            if ((int) session.getAttribute("rule") != 1) {
                response.sendRedirect("login");
                return;
            }
            Future<Void> future2 = ThreadPool.executorService.submit(() -> {

                if (request.getParameter("date1") != null) {
                    HK_NK xet = new HK_NK_dao().getHK_NKWithXetEqualOne();
                    Thong_Bao t = new Thong_Bao_dao().getThongBaoByHK_NKID(xet.getId());

                    String dateString = request.getParameter("date1");
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = formatter.parse(dateString);
                    t.setNgayBD(date);

                    dateString = request.getParameter("date2");
                    formatter = new SimpleDateFormat("yyyy-MM-dd");
                    date = formatter.parse(dateString);
                    t.setNgayKT_SV(date);

                    dateString = request.getParameter("date3");
                    formatter = new SimpleDateFormat("yyyy-MM-dd");
                    date = formatter.parse(dateString);
                    t.setNgayKT_CS(date);

                    dateString = request.getParameter("date4");
                    formatter = new SimpleDateFormat("yyyy-MM-dd");
                    date = formatter.parse(dateString);
                    t.setNgayKT_CV(date);

                    dateString = request.getParameter("date5");
                    formatter = new SimpleDateFormat("yyyy-MM-dd");
                    date = formatter.parse(dateString);
                    t.setNgayKT_Khoa(date);

                    new Thong_Bao_dao().updateThongBao(t);
                }

                return null;

            });
            try {
                future2.get();

            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(school_tkb.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("gv_tkb");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
