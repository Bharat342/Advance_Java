package com.mvc.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.mvc.model.AddService;


@WebServlet("/AddController")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int firstnum = Integer.parseInt(request.getParameter("firstnum"));
		int secondnum = Integer.parseInt(request.getParameter("secondnum"));
		
		AddService service = new AddService();
		int result = service.Addition(firstnum, secondnum);
		
		request.setAttribute("x", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("add.jsp");
		rd.forward(request, response);
	}

}
