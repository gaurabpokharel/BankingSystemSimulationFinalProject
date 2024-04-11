package com.project.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

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
 * Servlet implementation class SendMoneyServlet
 */
@WebServlet("/SendMoneyServlet")
public class SendMoneyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountDetailsDao accountDetailsDao = new AccountDetailsDao();
	TransactionDetailsDao transactionDetailsDao = new TransactionDetailsDao();

	/**
	 * Default constructor.
	 */
	public SendMoneyServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
			session.setAttribute("showModal2", true);
			session.setAttribute("amount", amount);
			response.sendRedirect("Welcome.jsp");
		}

		// Calling from SendMoneyJSP file
		if (formType != null && formType.equals("sendMoney")) {
			LocalDate localDate = LocalDate.now();
			Date date = Date.valueOf(localDate);
			HttpSession session = request.getSession();
			String storedValue = (String) session.getAttribute("storedValue");
			String receiverusername = request.getParameter("receiverusername");
			String receiveremail = request.getParameter("receiveremail");
			float receiveramount = Float.valueOf(request.getParameter("receiveramount"));
			String message = accountDetailsDao.increaseReceiverAmount(receiverusername, receiveremail, receiveramount);
			message = accountDetailsDao.decreaseSenderAmount(storedValue, receiveramount);
			TransactionDetails transactionDetails = new TransactionDetails(storedValue,receiverusername,receiveramount,date);
			message = transactionDetailsDao.saveTransctionDetails(transactionDetails);
			request.setAttribute("message", message);
			response.sendRedirect("Welcome.jsp");
		}

	}

}
