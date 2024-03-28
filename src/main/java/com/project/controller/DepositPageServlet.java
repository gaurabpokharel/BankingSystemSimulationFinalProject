package com.project.controller;

import java.io.IOException;

import com.project.dao.AccountDetailsDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
/**
 * Servlet implementation class DeposiPageServlet
 */
@WebServlet("/DepositPageServlet")
public class DepositPageServlet extends HttpServlet {
	AccountDetailsDao accountDetailsDao = new AccountDetailsDao();
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DepositPageServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formType = request.getParameter("formType");
		if (formType != null && formType.equals("fromWelcomeJSP")) {
		    response.sendRedirect("DepositPage.jsp");
		}
		
		if (formType != null && formType.equals("depositAmount")) {
			String username = request.getParameter("username");
			String accountType =request.getParameter("accountType");
			Float depositAmount = Float.valueOf(request.getParameter("depositAmount"));
			
			String msg = accountDetailsDao.increaseAccountTypeAmount(username, accountType, depositAmount);
		    response.sendRedirect("Welcome.jsp");
		}
		
	}

}
