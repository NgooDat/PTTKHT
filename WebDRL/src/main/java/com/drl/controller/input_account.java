package com.drl.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(urlPatterns = {"/forget-pass"})
public class input_account extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false);
        if(session==null) response.sendRedirect("login");
        if(session.getAttribute("token")==null) {
            response.sendRedirect("login");
            session.invalidate();
            return;
        }
        if(request.getParameter("token")==null ) {
            response.sendRedirect("login");
            session.invalidate();
            return;
        }
        if(!request.getParameter("token").equals((String)session.getAttribute("token"))){
            response.sendRedirect("login");
            session.invalidate();
            return;
        }
        //ArrayList<DRL> lop = new DRL_dao().getClass();
//        request.setAttribute("lopList", lop);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/login/input_account.jsp");
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
