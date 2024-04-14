package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.project.dao.AccountDetailsDao;

import jakarta.servlet.RequestDispatcher;
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

		if (formType != null && formType.equals("fromWelcomeJSP")) {
	    List<String> accountType = accountDetailsDao.getAccountType(storedValue);
	    session.setAttribute("accountType",accountType);
	    session.setAttribute("showModal", true);
	    response.sendRedirect("Welcome.jsp");
		}
		
		if (formType != null && formType.equals("transferMoney")) {
			String fromAccountType = request.getParameter("fromAccount");
			String toAccountType =  request.getParameter("toAccount");
			Float transferAmount = Float.valueOf(request.getParameter("transferamount"));
			try {
				Float availableAmountInFromAccountType = accountDetailsDao.getAccountBalanceInAccountType(storedValue,fromAccountType);
				if(availableAmountInFromAccountType >= transferAmount) {
				String message = accountDetailsDao.increaseAccountTypeAmount(storedValue, toAccountType, transferAmount);
				message = accountDetailsDao.decreaseAccountTypeAmount(storedValue, fromAccountType, transferAmount);
				response.sendRedirect("Welcome.jsp");
				}
				else {
					  request.setAttribute("error", "Insufficient balance in the selected account.");
			            RequestDispatcher dispatcher = request.getRequestDispatcher("Welcome.jsp");
			            dispatcher.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
