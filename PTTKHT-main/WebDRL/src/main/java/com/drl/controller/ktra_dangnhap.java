package com.drl.controller;

import com.drl.daos.Tai_Khoan_dao;
import com.drl.models.Tai_Khoan;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/ktra_dangnhap"})
public class ktra_dangnhap extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, InterruptedException, ExecutionException {
    	HttpSession session = request.getSession(false);
    	if(session!=null) {
    		String user = (String)session.getAttribute("username");
    		if(user!=null ) {
    			if(!user.equals("")) {
    				response.sendRedirect("school_home");
    				return;
    			}
    		}
    	}

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //Kiểm tra nếu người dùng không nhập gì??
        if(username ==null) {
        	response.sendRedirect("login");
        	return;
        }
        if(username.equals("") || password.equals("")){
            String message = "Vui lòng nhập đầy đủ thông tin!";
            request.setAttribute("message", message);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/login/login.jsp");
            dispatcher.forward(request, response);
            return;
        }
        boolean check = new Tai_Khoan_dao().checkLogin(username, password);
        if(check){
            Tai_Khoan tk =  Tai_Khoan_dao.getTaiKhoanLogin(username, password);
            session.setAttribute("username", username);
            if(tk.getStatus()==1){
                //Đăng nhập với tư cách gì???
                switch (tk.getRulesID()) {
                    case 1:
                        session.setAttribute("rule", 1);
                        response.sendRedirect("school_home");
                        return;
                    case 2:
                        session.setAttribute("rule", 2);
                        response.sendRedirect("khoa_home");
                        return;
                    case 3:
                        session.setAttribute("rule", 3);
                        response.sendRedirect("cv_home");
                        return;
                    case 4:
                        session.setAttribute("rule", 4);
                        response.sendRedirect("bcs_home");
                        return;
                    default:
                        session.setAttribute("rule",5);
                        response.sendRedirect("sv_home");
                        return;
                }
            }   
        }else{
            //đưa ra thông báo
            String message = "Tên đăng nhập hoặc mật khẩu không đúng!";
            request.setAttribute("message", message);
            request.setAttribute("password", password);
            request.setAttribute("username", username);
            RequestDispatcher dispatcher = request.getRequestDispatcher("views/login/login.jsp");
            dispatcher.forward(request, response);
        }
        
        response.setContentType("text/html;charset=UTF-8");
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InterruptedException | ExecutionException ex) {
            Logger.getLogger(ktra_dangnhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | InterruptedException | ExecutionException ex) {
            Logger.getLogger(ktra_dangnhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
