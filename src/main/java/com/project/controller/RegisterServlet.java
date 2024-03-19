package com.project.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.project.dao.UserDao;
import com.project.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RegisterServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		UserDao userDao = new UserDao();
		User user = new User(request.getParameter("username"), request.getParameter("password"),
				request.getParameter("email"), request.getParameter("phone"));
		String message = userDao.save(user);
		if ("Success".equalsIgnoreCase(message)) {
			out.println("User is created successfully");
			// Redirect to the index.jsp page after successful user creation
			response.sendRedirect("LoginPage.jsp");
		} else {
			out.print("Cannot create a user");
			// Include error message and forward back to the Register.jsp page
			request.setAttribute("errorMessage", "Failed to create user");
			RequestDispatcher rs = request.getRequestDispatcher("Register.jsp");
			rs.forward(request, response);
		}
	}

}
