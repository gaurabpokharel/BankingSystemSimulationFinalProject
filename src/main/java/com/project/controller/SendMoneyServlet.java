package com.project.controller;

import java.io.IOException;
import java.sql.SQLException;

import com.project.dao.AccountDetailsDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class SendMoneyServlet
 */
@WebServlet("/SendMoneyServlet")
public class SendMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountDetailsDao accountDetailsDao = new AccountDetailsDao();

    /**
     * Default constructor. 
     */
    public SendMoneyServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String formType = request.getParameter("formType");
		
		//Calling from Welcome JSP file
		if (formType != null && formType.equals("fromWelcomeJSP")) {
			HttpSession session = request.getSession();
	       String storedValue = (String) session.getAttribute("storedValue");
	       AccountDetailsDao accountDetailsDao = new AccountDetailsDao();
	       float amount = 0.0f;
	       try {
			amount = accountDetailsDao.getAccountBalance(storedValue);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       session.setAttribute("amount",amount);
	       response.sendRedirect("SendMoney.jsp");
		}
		
		//Calling from SendMoneyJSP file
		if (formType != null && formType.equals("sendMoney")) {
			HttpSession session = request.getSession();
		    String storedValue = (String) session.getAttribute("storedValue");
			String receiverusername = request.getParameter("receiverusername");
			String receiveremail = request.getParameter("receiveremail");
			float receiveramount = Float.valueOf(request.getParameter("receiveamount"));
			String message = accountDetailsDao.increaseReceiverAmount(receiverusername, receiveremail, receiveramount);
			message = accountDetailsDao.decreaseSenderAmount(storedValue, receiveramount);
			request.setAttribute("message", message);
	        response.sendRedirect("Welcome.jsp");
		}
		
	}

}
