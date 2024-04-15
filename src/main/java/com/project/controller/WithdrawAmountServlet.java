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
 * Author:Ajay Shrestha (C0885384) Gaurab Pokharel (C0886046) Nirajan Karki (C0885390) Sakar Thapa (C0890972)
 * Servlet implementation class WithdrawAmountServlet
 */
@WebServlet("/WithdrawAmountServlet")
public class WithdrawAmountServlet extends HttpServlet {

	AccountDetailsDao accountDetailsDao= new AccountDetailsDao();
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public WithdrawAmountServlet() {
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
	    session.setAttribute("showModal3", true);
	    response.sendRedirect("Welcome.jsp");
		}
		
		if (formType != null && formType.equals("withdrawAmount")) {
		String username = request.getParameter("username");
		String accountType = request.getParameter("accountType");
		Float amount = Float.valueOf(request.getParameter("withdrawAmount"));
		String msg = accountDetailsDao.decreaseAccountTypeAmount(username, accountType, amount);
		response.sendRedirect("Welcome.jsp");
		}
	}

}
