package com.flipkart.business;

import com.flipkart.DAO.AdminDao;
import com.flipkart.bean.*;

import java.util.List;
import java.util.ArrayList;

public class AdminOperation {

	
	private List<GymOwner> pendinGymOwnerList = new ArrayList<>();
    private List<GymCenter> pendinGymCentreList = new ArrayList<>();
    
    public AdminDao adminDao=new AdminDao();
	
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
		adminDao.approveGymOwnerRegistration(ownerId);
		return true;
	}
	
	public boolean approveGymCenter(long centerId)
	{
		System.out.println("Center with ID: "+centerId+" is approved");
		return true;
	}
	
	//TODO - task 2 (view)
	
	public List<GymCenter> viewPendingGymCentres(){
        return adminDao.viewPendingGymRequests();
        
    }


    public List<GymOwner> viewPendingGymOwners(){
        System.out.println("Viewing pending Gym Owner Approvals: ");
       return adminDao.viewPendingGymOwnerRequests();
    }
    public boolean validUser(String adminEmail, String password){
    	//verification part TODO
        return true;
    }
    public GymAdmin getAdminByEmail(String email) {
        GymAdmin admin = new GymAdmin();
        admin.setAdminName("Flipfit Admin");
        admin.setAdminEmailAddress("flipfit.admin@flipkart.com");
        admin.setPhone("123456789");
        admin.setPassword("password");
        return admin;
    }


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
