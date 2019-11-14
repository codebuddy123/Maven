package com.ashsoft.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashsoft.services.UserService;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		
		RequestDispatcher rd=null;
		
		UserService userService= new UserService();
		String status=userService.checkLogin(uname, upwd);
		
		if(status.equals("success"))
		{
			rd=request.getRequestDispatcher("success.html");
			rd.forward(request, response);
		}
		else
		{
			rd=request.getRequestDispatcher("failure.html");
			rd.forward(request, response);
		}
	}

}
