package com.comix.mangaawesome.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.comix.mangaawesome.database.DBManager;
import com.comix.mangaawesome.database.LoginDBManager;
import com.comix.mangaawesome.model.User;
import com.comix.mangaawesome.util.LoginUtil;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request , HttpServletResponse response) throws ServletException , IOException{
		response.setContentType("text/html");
		
		String email = "";
		String password = "";
		
		try{
			email = request.getParameter("email").trim();
			password = request.getParameter("password").trim();

		}catch(NullPointerException e){
			email = "";
			password = "";
		}
		
		try{
			System.out.println("Someone logining ...");
			DBManager dbmanager = (DBManager) request.getServletContext().getAttribute("dbmanager");
			LoginDBManager manager = new LoginDBManager(dbmanager.getConnection());
		
			User user = manager.getUserByEmailAndPassword(email, password);
			LoginUtil loginUtil = new LoginUtil(user);
			
			System.out.println("Email : " + email);
			System.out.println("Password : " + password);
			
			if(loginUtil.isAccess()){
				HttpSession session = request.getSession();
				session.setAttribute("current-user", user);
				System.out.println("Login Success.");
				response.getWriter().print("valid");		
			}else{
				System.out.println("Login Failed.");
				response.getWriter().print("invalid");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Login Failed.");
			response.getWriter().println("invalid");
		}
		
		
	}
	


}
