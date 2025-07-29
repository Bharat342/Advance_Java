package test;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/ReadServlet")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadServlet() {		
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();//  --> This line will give out reference using which we can write content to html 
		response.setContentType("text/html"); // to tell the browser that we running a html page.
		out.println("<table border= '1'>");
		out.println("<tr>");
		out.println("<td>");
		out.println("Name :");
		out.println("</td>");
		out.println("<td>");
		out.println("Email :");
		out.println("</td>");
		out.println("<td>");
		out.println("Phone :");
		out.println("</td>");
		out.println("<td>");
		out.println("Password :");
		out.println("</td>");
		out.println("</tr>");
		
		String url = "jdbc:mysql://localhost:3306/advjava";
		String un = "root";
		String pwd = "root";
		
		Connection con =null;
		Statement stmt = null;
		ResultSet res = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, un, pwd);
			
			stmt = con.createStatement();
			
			String query = "select * from registration";
			
			res = stmt.executeQuery(query);
			
//			ResultSetMetaData metaData = res.getMetaData();
//			
//			for(int i=1; i<=metaData.getColumnCount(); i++) {
//				System.out.println(metaData.getColumnLabel(i) + " = " + metaData.getColumnTypeName(i));
//			}
			
			while(res.next()) {
				out.println("<tr>");
				out.println("<td>");
				out.println(res.getString(1));
				out.println("</td>");
				out.println("<td>");
				out.println(res.getString(2));
				out.println("</td>");
				out.println("<td>");
				out.println(res.getString(3));
				out.println("</td>");
				out.println("<td>");
				out.println(res.getString(4));
				out.println("</td>");
				out.println("</tr>");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				res.close();
				stmt.close();
				con.close();
			}catch(Exception f) {
				f.printStackTrace();
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("post");

	}

}
