package com.flipkart.business;

import com.flipkart.bean.Admin;
import com.flipkart.bean.*;

import java.util.List;
import java.util.ArrayList;

public class AdminOperation {
	Admin admin = new Admin();
	
	private List<GymOwner> pendinGymOwnerList = new ArrayList<>();
    private List<Centre> pendinGymCentreList = new ArrayList<>();
	
	public void createAdmin(long adminId, String adminName, String adminEmail, String adminPhone, String password)
	{
		admin.setAdminId(adminId);
		admin.setAdminName(adminName);
		admin.setAdminEmailAddress(adminEmail);
		admin.setPhone(adminPhone);
		admin.setPassword(password);
		return;
	}
	// 1- approve requests  2- view stuffs
	
	//TODO - task 1 (approve)
	
	public boolean approveGymOwner(long ownerId)
	{
		System.out.println("Owner with ID: "+ownerId+" is approved");
		return true;
	}
	
	public boolean approveGymCenter(long centerId)
	{
		System.out.println("Center with ID: "+centerId+" is approved");
		return true;
	}
	
	//TODO - task 2 (view)
	
	public List<Centre> viewPendingGymCentres(){
        pendinGymCentreList = new ArrayList<>(); // TODO -> get the list
        return pendinGymCentreList;
    }

    public List<GymOwner> viewPendingGymOwners(){
        System.out.println("Viewing pending Gym Owner Approvals: ");
        pendinGymOwnerList = new ArrayList<>();  //TODO -> get the list
        return pendinGymOwnerList;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
