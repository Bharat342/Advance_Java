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


@WebServlet("/DeleteRecordController")
public class DeleteRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteRecordController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		
//			 query parameter is a concept using which we can supply values through URL
			String email = request.getParameter("email");// -> fetching the email from the jsp page delete button
			
			// using that email we can call the ServiceArea's method to delete the record based on that email
			ServiceArea service = new ServiceArea();
			service.connectDb();
			service.deleteRegistrationRecord(email);
			
			HttpSession session = request.getSession(false);
			String emailId = (String)session.getAttribute("email");
			
			ResultSet result = service.getUserByEmail(emailId);
			
			int user_id = 0;
			if(result.next()) {
				user_id = result.getInt(1);
			}
			
			ResultSet res = service.fetchUserRegistrationData(user_id);
			
			request.setAttribute("fetchedData", res);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/RegistrationData.jsp");
			rd.forward(request, response);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
































