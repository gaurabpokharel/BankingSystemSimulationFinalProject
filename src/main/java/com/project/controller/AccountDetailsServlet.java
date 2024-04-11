package com.project.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import com.project.dao.AccountDetailsDao;
import com.project.model.AccountDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 * Servlet implementation class AccountDetails
 */
@WebServlet("/AccountDetailsServlet")
public class AccountDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	AccountDetailsDao accountDetailsDao = new AccountDetailsDao();

    /**
     * Default constructor. 
     */
    public AccountDetailsServlet() {
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
		//Calling from Welcome JSP file
		if (formType != null && formType.equals("fromWelcomeJSP")) {
			HttpSession session = request.getSession();
		    String storedValue = (String) session.getAttribute("storedValue");
		    System.out.println(storedValue);
		    response.sendRedirect("CreateAccount.jsp");
		}
		
		if (formType != null && formType.equals("createAccount")) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fullName = request.getParameter("fullname");
		Date dob = null;
		try {
			java.util.Date utilDob = dateFormat.parse(request.getParameter("dob"));
			dob = new Date(utilDob.getTime());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String gender = request.getParameter("gender");
		String userName =request.getParameter("username");
		String email = request.getParameter("email");
		String sin = request.getParameter("sin");
		String street = request.getParameter("street");
		String building = request.getParameter("building");
		String postalCode = request.getParameter("postalCode");
		String accountType = request.getParameter("accountType");
		Float initalDeposit = Float.valueOf(request.getParameter("initialDeposit"));
		String sourceOfFunds = request.getParameter("sourceOfFunds");
		
		AccountDetails accountDetails = new AccountDetails(fullName, dob, gender, userName, 
				email, sin, street, building, postalCode, accountType, initalDeposit, sourceOfFunds);
		
		String message = accountDetailsDao.saveAccount(accountDetails);
		response.sendRedirect("Welcome.jsp");
		System.out.println("Account details: "+ message);
	}
	}
}
