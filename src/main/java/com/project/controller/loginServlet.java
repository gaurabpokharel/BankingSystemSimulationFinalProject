package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.project.dao.UserDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Author:Ajay Shrestha (C0885384) Gaurab Pokharel (C0886046) Nirajan Karki (C0885390) Sakar Thapa (C0890972)
 * Servlet implementation class loginServlet
 */
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public loginServlet() {
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
	PrintWriter out = response.getWriter();
	String un=request.getParameter("username");
	String pw =request.getParameter("password");
	UserDao userDao = new UserDao();
	String returnValue = userDao.loginDetails(un,pw);
	if (returnValue.equalsIgnoreCase("Success")) {
		HttpSession session = request.getSession();
		session.setAttribute("storedValue", un);
		response.sendRedirect("Welcome.jsp");
	    out.close();
	} else {
		out.print("Login Failed");
		// Include error message and forward back to the Register.jsp page
		request.setAttribute("errorMessage", "Login Failed");
		RequestDispatcher rs = request.getRequestDispatcher("LoginPage.jsp");
		rs.forward(request, response);
	}
	}

}
