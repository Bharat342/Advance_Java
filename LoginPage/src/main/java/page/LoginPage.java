package page;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginPage() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("yeh get() hai saleem!..");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		
		String url = "jdbc:mysql://localhost:3306/login_details";
		String un = "root";
		String pwd = "root";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(url, un, pwd);
			
			Statement stmt = con.createStatement();
			
			String query = "insert into userdata (name, password, subscribe, email) values ('"+name+"', '1111', 't', '"+email+"')";
			
			stmt.executeUpdate(query);
			
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			
			out.println("<h1>Account Created Successfully...</h1>");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}




















