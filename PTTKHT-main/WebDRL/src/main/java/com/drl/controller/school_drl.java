package com.drl.controller;

import com.drl.daos.DRL_dao;
import com.drl.models.DRL;
import com.drl.tools.ThreadPool;
import java.io.IOException;
import java.util.ArrayList;
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


@WebServlet(urlPatterns = {"/school_drl"})
public class school_drl extends HttpServlet {


	private static final long serialVersionUID = 1L;
        private ArrayList<DRL> drlList =   null;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, InterruptedException, ExecutionException {
        response.setContentType("text/html;charset=UTF-8");
        
        Future<Void> future = ThreadPool.executorService.submit(() -> {
            drlList = (ArrayList<DRL>) DRL_dao.getAllDRLWithTotal();
            return null; 
        });
        future.get();
        request.setAttribute("drlList", drlList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/school/admin_drl.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(school_drl.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            try {
                processRequest(request, response);
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(school_drl.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
