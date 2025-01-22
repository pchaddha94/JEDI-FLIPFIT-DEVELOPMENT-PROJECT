package com.flipkart.business;

import com.flipkart.bean.*;

import java.util.List;
import java.util.ArrayList;

public class AdminOperation {
	private GymAdmin admin = new GymAdmin();
	
	private List<GymOwner> pendinGymOwnerList = new ArrayList<>();
    private List<GymCenter> pendinGymCentreList = new ArrayList<>();
	
    public GymAdmin createAdmin(long adminId, String adminName, String adminEmail, String adminPhone, String password) {
        GymAdmin admin = new GymAdmin();
        admin.setAdminId(adminId);
        admin.setAdminName(adminName);
        admin.setAdminEmailAddress(adminEmail);
        admin.setPhone(adminPhone);
        admin.setPassword(password);
        return admin;
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
	
	public List<GymCenter> viewPendingGymCentres(){
        pendinGymCentreList = new ArrayList<>(); // TODO -> get the list
        return pendinGymCentreList;
    }

    public List<GymOwner> viewPendingGymOwners(){
        System.out.println("Viewing pending Gym Owner Approvals: ");
        pendinGymOwnerList = new ArrayList<>();  //TODO -> get the list
        return pendinGymOwnerList;
    }
    public boolean validUser(String adminEmail, String password){
        return true;
    }
    public GymAdmin getAdminByEmail(String email) {
        GymAdmin admin = new GymAdmin();
        admin.setAdminName("John Doe");
        admin.setAdminEmailAddress("john.doe@flipkart.com");
        admin.setPhone("123456789");
        admin.setPassword("password");
        return admin;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
