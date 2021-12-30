package com.app.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println("LoginServlet -> service : starts");
		
		String page = "login.jsp";
		RequestDispatcher rd = null;
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("username : " +username+" , password : "+password);
		
		if(username.equals(password)) {
			rd = request.getRequestDispatcher("home.jsp");
		}else {
			rd = request.getRequestDispatcher("login.jsp");
			request.setAttribute("message", "username/password is incorrect..");
		}
		
		rd.forward(request, response);
		
		System.out.println("LoginServlet -> service : ends");
	
	}
}
