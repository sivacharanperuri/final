package com.controllers;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginChecker")
public class LoginChecker extends HttpServlet {
	static Connection connection = null; 
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (Exception e) {
			System.out.println("Driver class not found");
		}
	
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("user_id");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		PrintWriter out = response.getWriter();
		if(validateLogin(userid, password,type) )
		{
			  HttpSession session=request.getSession();  
		      session.setAttribute("user_id",userid);  
			if(type.equals("maker")) 
          response.sendRedirect("maker.html");
			if(type.equals("checker")) 
				response.sendRedirect("checker.html");

		}
		else
		{
			response.sendRedirect("LoginPageError.html");
			
		}
	}

	private boolean validateLogin(String userid, String password,String type) {
		try {
		   Statement statement = connection.createStatement();
			// Execute a Query
			String query = "select count(user_id) from login_db where user_id ='" +userid+"' and password ='"+password+"'and user_type='"+type+"'";
			ResultSet loginResult = statement.executeQuery(query);
			// Iterate through the result set and display the records.
			if (loginResult.next()) {
				if(loginResult.getInt(1) > 0)
				return true;
			}

	} catch (SQLException exception) {
			System.out.println(exception);
		}
		return false;
	}
}
