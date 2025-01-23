package com.flipkart.DAO;

import java.util.List;

import com.flipkart.bean.GymAdmin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

public interface AdminDaoInterface {
	
public List<GymCenter> viewPendingGymRequests();
	
	public List<GymOwner> viewPendingGymOwnerRequests();
	
	public List<GymCenter> viewAllApprovedGyms();
	
	public List<GymOwner> viewAllApprovedGymOnwers();
	
	public boolean approveGymOwnerRegistration(int gymOwnerId);
	
	public boolean approveGymRegistration(int gymCenterId);
	
	public void addAdmin(GymAdmin gymAdmin);

	public GymAdmin getAdminByEmail(String email);
}
