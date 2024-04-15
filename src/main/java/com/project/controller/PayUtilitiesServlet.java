package com.project.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

import com.project.dao.AccountDetailsDao;
import com.project.dao.TransactionDetailsDao;
import com.project.model.TransactionDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Author:Ajay Shrestha (C0885384) Gaurab Pokharel (C0886046) Nirajan Karki (C0885390) Sakar Thapa (C0890972)
 * Servlet implementation class PayUtilitiesServlet
 */
@WebServlet("/PayUtilitiesServlet")
public class PayUtilitiesServlet extends HttpServlet {
	AccountDetailsDao accountDetailsDao = new AccountDetailsDao();
	TransactionDetailsDao transactionDetailsDao = new TransactionDetailsDao();
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PayUtilitiesServlet() {
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
			session.setAttribute("showModal4", true);
			session.setAttribute("amount", amount);
			response.sendRedirect("Welcome.jsp");
		}
		
		if (formType != null && formType.equals("payUtilities")) {
			LocalDate localDate = LocalDate.now();
			Date date = Date.valueOf(localDate);
			HttpSession session = request.getSession();
			String storedValue = (String) session.getAttribute("storedValue");
			String receiverusername = request.getParameter("payTo");
			float receiveramount = Float.valueOf(request.getParameter("withdrawAmount"));
			String message = accountDetailsDao.decreaseSenderAmount(storedValue, receiveramount);
			TransactionDetails transactionDetails = new TransactionDetails(storedValue,receiverusername,receiveramount,date);
			message = transactionDetailsDao.saveTransctionDetails(transactionDetails);
			request.setAttribute("message", message);
			response.sendRedirect("Welcome.jsp");
		}
	}

}
