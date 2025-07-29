package test;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FirstPage")
public class FirstPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstPage() {
		super();
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//		// In this line we are creating a pointer of the destination Servlet page so that we can transfer the control to the destination page.
//		RequestDispatcher rd = request.getRequestDispatcher("SecondPage");
//		
//		// Here we are calling the SecondPage ServletPage using the pointer reference(rd)
//		rd.forward(request, response);
//	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// Servlet calls JSP Page and also servlet supplies data to jsp implicit object
		
		// if we run the server from this page then the server will call the doGet()
		// and we want to call jsp page from this page for that we have to call from the this method.
		
		// What is the return type of getAttributes = Object
		// how can we change that to String = by using type casting.
		
		
		request.setAttribute("x", "Sharada katti/ mangya");
		
		// rd is point to jsp page.
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp"); 
		rd.forward(request, response);
		
	}

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		// Supply data from html form to first servlet and then form first servlet supply data to second servlet using request.setAttribute.
//		
//		String name = request.getParameter("name");
//		
//		request.setAttribute("x", name);
//		
//		RequestDispatcher rd = request.getRequestDispatcher("SecondPage");
//		rd.forward(request, response);
//		
//		
//	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
