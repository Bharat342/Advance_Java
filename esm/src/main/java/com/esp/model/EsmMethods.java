package com.esp.model;

public interface EsmMethods {
	
	public void connectDB();
	
	public boolean verifyUser(String email, String password);

}
