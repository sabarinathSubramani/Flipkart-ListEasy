package fk.sp.ListEasy.springs.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



	public class HomePageServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet( HttpServletRequest request,
		                        HttpServletResponse response)
		        throws ServletException, IOException {
			response.setContentType("text/html");
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);

		  }
		
}