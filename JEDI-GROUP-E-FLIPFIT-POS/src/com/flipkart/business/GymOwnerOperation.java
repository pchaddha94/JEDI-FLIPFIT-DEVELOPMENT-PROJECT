package com.flipkart.business;

import com.flipkart.bean.BookSlot;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.utils.UserRole;

import java.util.List;

public class GymOwnerOperation {
	
    public Boolean AddCentre(Long centreID){
        return true;

    }
    public Boolean AddSlot(Slot slot, Long centreID){
        return true;
    }

    public Boolean RemoveCentre(Long centreID){
        return true;
    }

    public Boolean RemoveSlot(Slot slot, Long centreID){
        return true;
    }

    public List<BookSlot> ViewBookings(Long centreID){

        return null;
    }
    
    public boolean validUser(String email, String password){
        return true;
    }
    
    
    public GymOwner createGymOwner(long ownerId,
     String ownerName,
     String ownerEmailAddress,
     String ownerPhone,
     String ownerPanNum,
     boolean isApproved,
     String ownerAddress) {
    	GymOwner gymOwner= new GymOwner();
    	gymOwner.setApproved(isApproved);
    	gymOwner.setOwnerAddress(ownerAddress);
    	gymOwner.setOwnerEmailAddress(ownerEmailAddress);
    	gymOwner.setOwnerId(ownerId);
    	gymOwner.setOwnerName(ownerName);
    	gymOwner.setOwnerPanNum(ownerPanNum);
    	gymOwner.setOwnerPhone(ownerPhone);

    	
    	return gymOwner;
    }
    
    
    //Todo (take from database)
    public GymOwner getGymOwnerByEmail(String email){
    	return null;
    	
    }



}
