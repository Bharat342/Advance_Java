package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		String url = "jdbc:mysql://localhost:3306/advjava";
		String un = "root";
		String pwd = "root";
		
		Connection con = null;
		Statement stmt = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, un, pwd);
			
			stmt = con.createStatement();
			
			String query = "delete from Registration where name = '"+name+"'";		
			
			ResultSet res = stmt.executeQuery("select password from registration where name = '"+name+"'");
			res.next();
			
			if(res.getString(1).equals(password)) {
				stmt.executeUpdate(query);
			} else {
				System.out.println("invalid input!");
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
				stmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
