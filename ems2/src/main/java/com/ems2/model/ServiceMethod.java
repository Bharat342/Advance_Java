package com.ems2.model;

import java.sql.ResultSet;

public interface ServiceMethod {
	public void connectDb();
	public boolean verifyLogin(String email, String password);
	public ResultSet getUserByEmail(String email);
	public boolean createRegistration(int id, String name, String course, String email, String mobile);
	public ResultSet fetchUserRegistrationData(int user_id);
	public void deleteRegistrationRecord(String email);
	public ResultSet fetchRegDatabyId(int id);
	public void updateRegData(int id, String name, String course, String email, String mobile);
}
