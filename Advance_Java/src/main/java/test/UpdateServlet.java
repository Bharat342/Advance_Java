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
@WebServlet("/Update")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		
		String url = "jdbc:mysql://localhost:3306/advjava";
		String un = "root";
		String pwd = "root";
		
		Connection con = null;
		Statement stmt = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, un, pwd);
			
			stmt = con.createStatement();
			
			String query = "update registration set phone = '"+phone+"' where name = '"+name+"'";		
			
			stmt.executeUpdate(query);
			
			
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
