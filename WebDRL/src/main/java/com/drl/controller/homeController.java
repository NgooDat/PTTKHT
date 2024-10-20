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
import com.drl.daos.Khoa_Hoc_dao;
import com.drl.daos.Khoa_dao;
import com.drl.daos.Lop_dao;
import com.drl.daos.Sinh_Vien_dao;
import com.drl.daos.Tieu_Chi_dao;
import com.drl.models.CT_TC;
import com.drl.models.DRL;
import com.drl.models.Diem_CT;
import com.drl.models.Giang_Vien;
import com.drl.models.Khoa;
import com.drl.models.Khoa_Hoc;
import com.drl.models.Lop;
import com.drl.models.Sinh_Vien;
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
//			DRL_dao d=new DRL_dao();
//			boolean isS=d.updateDiem(1, "SV");
//			request.setAttribute("SV", isS);
			//Sinh_Vien s=new Sinh_Vien_dao().getSV_by_email("sv01@example.com");
			//System.out.println(s.getHoTen());
			String dateString = "2024-10-18";
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        Date date = formatter.parse(dateString);
	       
	        //List<DRL> ls=new DRL_dao().getDRL_by_status(1);
	        DRL ls=new DRL(3,0, 0, 0, 1, "SV03", 1);
	        boolean iss= new DRL_dao().deleteDRL(3);
			request.setAttribute("SV", iss);	
			RequestDispatcher rd= request.getRequestDispatcher("index.jsp");
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
