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


@WebServlet("/ReadRegistrationController")
public class ReadRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReadRegistrationController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			// accessing the session variable data which can be access by any where (We created session variable before and we are now accessing that session variable data)
			HttpSession session = request.getSession(false);
			String email = (String)session.getAttribute("email"); // -> Here it returns Object type thats why we are type-casting by String
			
			// Here we are creating a object of 'ServiceArea' object reference so that we can access methods present inside it
			ServiceArea service = new ServiceArea();
			service.connectDb(); // -> Connecting with the database
			ResultSet result = service.getUserByEmail(email); // -> getting the user data by 'email' id which we have already saved in session variable while login and
			
			// And by that result we are fetching the user 'id' and using this 'id' we can call the 'fetchRegistrationData' method by passing this 'id' as a parameter
			// which will fetch the registration data belongs to that 'id'
			int id = 0;
			if(result.next()) {
				id = result.getInt(1);
			}
			
			ResultSet fetchedData = service.fetchUserRegistrationData(id); // this method will return ResultSet we are storing the data in a variable
			// and this data we can print in a JSP Page.
			
			request.setAttribute("fetchedData", fetchedData);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/RegistrationData.jsp");
			rd.forward(request, response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
