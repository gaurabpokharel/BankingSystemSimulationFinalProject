package com.project.controller;

import java.io.IOException;
import java.util.List;

import com.project.dao.AccountDetailsDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;	

/**
 * Servlet implementation class TransferBetweenAccountsServlet
 */
@WebServlet("/TransferBetweenAccountsServlet")
public class TransferBetweenAccountsServlet extends HttpServlet {
	AccountDetailsDao accountDetailsDao = new AccountDetailsDao();
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TransferBetweenAccountsServlet() {
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
		HttpSession session = request.getSession();
	    String storedValue = (String) session.getAttribute("storedValue");
		String formType = request.getParameter("formType");
		
		//Calling from Welcome JSP file
		if (formType != null && formType.equals("fromWelcomeJSP")) {
	    List<String> accountType = accountDetailsDao.getAccountType(storedValue);
	    session.setAttribute("acountType",accountType);
	    response.sendRedirect("TransferBetweenAccounts.jsp");
		}
		
		if (formType != null && formType.equals("transferMoney")) {
			String fromAccountType = request.getParameter("fromAccount");
			String toAccountType =  request.getParameter("toAccount");
			Float transferAmount = Float.valueOf(request.getParameter("transferamount"));
			String message = accountDetailsDao.increaseAccountTypeAmount(storedValue, toAccountType, transferAmount);
			message = accountDetailsDao.decreaseAccountTypeAmount(storedValue, fromAccountType, transferAmount);
			response.sendRedirect("Welcome.jsp");
		}
		
		
	}

}
