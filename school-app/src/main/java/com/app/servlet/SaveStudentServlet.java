package com.app.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SaveStudentServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		
		System.out.println("SaveStudentServlet -> service : starts");
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		Student student = new Student();
		student.setId(001);
		student.setName(name);
		student.setEmail(email);
		student.setGender(gender);
		student.setAddress(address);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		request.setAttribute("student", student);
		rd.forward(request, response);
		
		System.out.println("SaveStudentServlet -> service : ends");
	}
}
	