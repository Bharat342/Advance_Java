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

@WebServlet("/UpdateRecordController")
public class UpdateRecordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateRecordController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			
			ServiceArea service = new ServiceArea();
			service.connectDb();
			ResultSet result = service.fetchRegDatabyId(id);
			
			if(result.next()) {
				request.setAttribute("id", result.getInt(1));
				request.setAttribute("name", result.getString(2));
				request.setAttribute("course", result.getString(3));
				request.setAttribute("email", result.getString(4));
				request.setAttribute("mobile", result.getString(5));
			}
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/updateRegData.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String course =request.getParameter("course");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			
			ServiceArea service = new ServiceArea();
			service.connectDb();
			service.updateRegData(id, name, course, email, mobile);// This line is updating the record to new values.
			
			
			HttpSession session = request.getSession(false);
			String emailId = (String)session.getAttribute("email");
			
			service.connectDb();
			ResultSet result = service.getUserByEmail(emailId); // -> getting the user data by 'email' id which we have already saved in session variable while login and
			
			int uid = 0;
			if(result.next()) {
				uid = result.getInt(1);
			}
			
			ResultSet userResult = service.fetchUserRegistrationData(uid); // this method will return ResultSet we are storing the data in a variable
			// and this data we can print in a JSP Page.
			
			request.setAttribute("fetchedData", userResult);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/RegistrationData.jsp");
			rd.forward(request, response);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
















