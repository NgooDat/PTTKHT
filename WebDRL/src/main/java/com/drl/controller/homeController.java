package com.drl.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.drl.daos.CT_TC_dao;
import com.drl.daos.DRL_dao;
import com.drl.daos.Diem_CT_dao;
import com.drl.daos.Giang_Vien_dao;
import com.drl.daos.HK_NK_dao;
import com.drl.daos.Khoa_Hoc_dao;
import com.drl.daos.Khoa_dao;
import com.drl.daos.Lop_dao;
import com.drl.daos.Rules_dao;
import com.drl.daos.Sinh_Vien_dao;
import com.drl.daos.Tai_Khoan_dao;
import com.drl.daos.Thong_Bao_dao;
import com.drl.daos.Tieu_Chi_dao;
import com.drl.models.CT_TC;
import com.drl.models.DRL;
import com.drl.models.Diem_CT;
import com.drl.models.Giang_Vien;
import com.drl.models.HK_NK;
import com.drl.models.Khoa;
import com.drl.models.Khoa_Hoc;
import com.drl.models.Lop;
import com.drl.models.Rules;
import com.drl.models.Sinh_Vien;
import com.drl.models.Tai_Khoan;
import com.drl.models.Thong_Bao;
import com.drl.models.Tieu_Chi;

/**
 * Servlet implementation class homeController
 */
@WebServlet("/home")
public class homeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public homeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			String dateString = "2025-10-18";
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = formatter.parse(dateString);
	       
	       
	        //List<Thong_Bao> ls=new Thong_Bao_dao().getAllThongBao();
	        Thong_Bao tb=new Thong_Bao(3,date, date, date, date, date, 3);
	        
	        boolean iss= new Thong_Bao_dao().deleteThongBao(3) ;
			request.setAttribute("SV", iss);	
			RequestDispatcher rd= request.getRequestDispatcher("idte.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
