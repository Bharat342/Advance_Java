package com.ems2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ems2.model.ServiceArea;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		ServiceArea loginService = new ServiceArea();
		loginService.connectDb();
		
		boolean result = loginService.verifyLogin(email, password);
		
		if(result) {
			
			//-> if we devlop .html/.jsp page inside webapp then they are accessed publicly.
			// -> then those pages that are ketp indise webapp/ webINF can be accessed only by servlets.
			//-> session variabeles : once we stored data inside a session variable then that data can be accessed across the application
			
			// exp : user profile, logout etc.
			
			HttpSession session = request.getSession(true); // -> Creating a session variable and assigning to the local variable
			// -> Here we are creating and session variable which we can be accessable from all the pages like : 
			//                           LoginController(Servlet), RegistrationController(Servlet) & jsp page also.
			// if it is a 'request.setAttributes' we are exchanging the data between servlet to servlet / servlet to jsp 
			 // we are suppling the data from one servlet to another of servlet to jsp or jsp to servlet.(we are exchanging the data)
			// now we want to kept the data in such a way so that which ever page of my application/ which ever servlet of my application we are using
			// that data should be accessable by them.
			// for that only here we are using 'session variable' once we store the data in session variable that data who ever wants to access
			// they can retrive the data through the sesssion variable.
			
			session.setAttribute("email", email);// in this session we can set the data (we are storing here email)
			// This  email id if we have i can write a query in a database and i can get the record based on that email id.
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/registration.jsp");
			rd.forward(request, response);
			
		}else {
			request.setAttribute("errmsg", "invalid email/ password");
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		
	}

}
