package com.empcrud.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
	
    public LoginController() {
        super();
        }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String userName = request.getParameter("user_email");
		String userPassword = request.getParameter("user_password");
		
		//System.out.println(userName + " " + userPassword);
		if(userName.equals("admin@gmail.com") && userPassword.equals("admin")) {
			session.setAttribute("email_id", userName);
			response.sendRedirect("EmployeeController?action=LIST");
		}
		else {
			response.sendRedirect("index.jsp");
		}
		
	}
}
