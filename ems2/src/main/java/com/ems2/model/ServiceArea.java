package com.ems2.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceArea implements ServiceMethod {
	
	String url = "jdbc:mysql://localhost:3306/esm";
	String un = "root";
	String pwd = "root";
	
	Connection con = null;
	Statement stmt = null;

	@Override
	public void connectDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(url, un, pwd);
			stmt = con.createStatement();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean verifyLogin(String email, String password) {
		try {
			ResultSet res = stmt.executeQuery("select * from user_data where email = '"+email+"' and password = '"+password+"'");
			return res.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet getUserByEmail(String email) {
		try {
//			return stmt.executeQuery("select * from user_data where email = '"+email+"'");
			ResultSet result = stmt.executeQuery("select * from user_data where email = '"+email+"'");
			return result;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean createRegistration(int id, String name, String course, String email, String mobile) {
		try {
			String query = "insert into registration_details (name, course, email, mobile, user_id) values ('"+name+"', '"+course+"', '"+email+"', '"+mobile+"', '"+id+"')";
			
//			if(name != null && course != null && email != null && mobile != null) {
			if(name.length() > 1 && course.length() > 1 && email.length() > 1 && mobile.length() > 1) {
				stmt.executeUpdate(query);
				return true;
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ResultSet fetchUserRegistrationData(int user_id) {
		try {
			String query = "select * from registration_details where user_id = '"+user_id+"'";
			return stmt.executeQuery(query);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteRegistrationRecord(String email) {
		try {
			String query = "delete from registration_details where email = '"+email+"'";
			stmt.executeUpdate(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ResultSet fetchRegDatabyId(int id) {
		try {
			String query = "select * from registration_details where id = '"+id+"'";
			return stmt.executeQuery(query);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateRegData(int id, String name, String course, String email, String mobile) {
		try {
			String query = "update registration_details set name = '"+name+"', course = '"+course+"', email = '"+email+"', mobile = '"+mobile+"' where id = '"+id+"'";
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

}













