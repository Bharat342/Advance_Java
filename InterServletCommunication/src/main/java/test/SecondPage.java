package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/SecondPage")
public class SecondPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public SecondPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Second Servlet Get Method");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Second Servlet Post Method");
	
		// Supply data from html form to first servlet and then form first servlet supply data to second servlet using request.setAttribute.
		
		String name = (String)request.getAttribute("x");
		
		response.setContentType("text/html");
		System.out.println("SecondServlet post method : " + name);
		
	}

}
