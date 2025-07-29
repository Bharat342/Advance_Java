package com.esp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class EsmServices implements EsmMethods {
	
	private Connection con = null;
	private Statement stmt = null;
	
	String url = "jdbc:mysql://localhost:3306/esm";
	String un = "root";
	String pwd = "root";
	
	@Override
	public void connectDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, un, pwd);
			stmt = con.createStatement();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyUser(String email, String password) {
		try {
			ResultSet res = stmt.executeQuery("select * from user_data where email = '"+email+"' and password = '"+password+"'");
			return res.next();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
