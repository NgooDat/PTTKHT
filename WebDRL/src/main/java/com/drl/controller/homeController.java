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

import com.drl.daos.DRL_dao;
import com.drl.daos.Giang_Vien_dao;
import com.drl.daos.Khoa_Hoc_dao;
import com.drl.daos.Khoa_dao;
import com.drl.daos.Sinh_Vien_dao;
import com.drl.models.Giang_Vien;
import com.drl.models.Khoa;
import com.drl.models.Khoa_Hoc;
import com.drl.models.Sinh_Vien;

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
			DRL_dao d=new DRL_dao();
			boolean isS=d.updateDiem(1, "SV");
			request.setAttribute("SV", isS);
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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
