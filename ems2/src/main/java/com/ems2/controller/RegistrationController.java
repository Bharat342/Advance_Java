package com.ems2.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;

import com.ems2.model.ServiceArea;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// when we click on the link on 'menu.jsp' page that control come to here inside the doGet()
		// from here we are transferring the control to 'registration.jsp' Page.(doGet() method will load the registration page)
		 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/registration.jsp");
		 rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// When we are login we are storing data in the session variable and that session variable we can access from any page.
			// we created the session variable in 'LoginController.java' page and stored the data in session variable.
			// and that session variable data we are trying to get Here in this page
			// Here we are doing the person who logged into the page his details we are saving inside the session variable.
			
			
			HttpSession session = request.getSession(false); // true means create the session variable and false means use the existing session variable thats why we made this as false.
			//even if we don't give this line it will work but it is a good practice to give this line
		
			String emailid = (String)session.getAttribute("email"); // -> Return type of this is 'Object' type thats why we are type casting this to String.
			
			ServiceArea registrationRef = new ServiceArea();
			
			registrationRef.connectDb();
			ResultSet result = registrationRef.getUserByEmail(emailid);
			int id = 0;
			while(result.next()) {
				id = result.getInt(1);
			}
			
			String name = request.getParameter("name");
			String course = request.getParameter("course");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
			boolean regStatus = registrationRef.createRegistration(id, name, course, email, mobile);
			if(regStatus) {
				request.setAttribute("message", "Registration Successful.");
			}else {
				request.setAttribute("errMessage", "Registration Failed...");
			}
			
		    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/registration.jsp");
		    rd.forward(request, response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
