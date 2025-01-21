package com.flipkart.business;

import com.flipkart.bean.Admin;

public class AdminOperation {
	Admin admin = new Admin();
	
	public void createAdmin(long adminId, String adminName, String adminEmail, String adminPhone, String password)
	{
		admin.setAdminId(adminId);
		admin.setAdminName(adminName);
		admin.setAdminEmailAddress(adminEmail);
		admin.setPhone(adminPhone);
		admin.setPassword(password);
		return;
	}
	// view gym

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
