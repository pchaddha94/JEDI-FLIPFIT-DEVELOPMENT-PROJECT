package com.flipkart.business;

import com.flipkart.DAO.OwnerDAO;
import com.flipkart.DAO.OwnerDAOInterface;
import com.flipkart.DAO.SlotsDAO;
import com.flipkart.DAO.SlotsDAOInterface;
import com.flipkart.bean.BookSlot;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;

import java.util.List;
import java.util.Objects;

public class GymOwnerOperation {

    private OwnerDAOInterface ownerDAO=new OwnerDAO();
    private SlotsDAOInterface slotsDAO=new SlotsDAO();

	
    public void addCentre(GymCenter gymCenter){
        ownerDAO.addCenter(gymCenter);
    }
    public Boolean addSlot(Slot slot){
        slotsDAO.addSlot(slot);
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
        GymOwner gymOwner = ownerDAO.getGymOwnerByEmail(email);
        if(Objects.isNull(gymOwner) || Objects.isNull(gymOwner.getPassword()) || !Objects.equals(gymOwner.getPassword(), password)){
//            System.out.println("Invalid email or password");
            return false;
        }
        return true;
    }
    
    
    public GymOwner createGymOwner(
     String ownerName,
     String ownerEmailAddress,
     String ownerPassword,
     String ownerPhone,
     String ownerPanNum,
     boolean isApproved,
     String ownerAddress) {
    	GymOwner gymOwner= new GymOwner();
    	gymOwner.setApproved(isApproved);
    	gymOwner.setOwnerAddress(ownerAddress);
    	gymOwner.setOwnerEmailAddress(ownerEmailAddress);
    	gymOwner.setOwnerName(ownerName);
        gymOwner.setPassword(ownerPassword);
    	gymOwner.setOwnerPanNum(ownerPanNum);
    	gymOwner.setOwnerPhone(ownerPhone);

        ownerDAO.addOwner(gymOwner);
    	return gymOwner;
    }
    
    
    //Todo (take from database)
    public GymOwner getGymOwnerByEmail(String email){
    	return ownerDAO.getGymOwnerByEmail(email);
    	
    }



}
