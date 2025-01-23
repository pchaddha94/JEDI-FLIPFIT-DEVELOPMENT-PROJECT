package com.flipkart.business;

import com.flipkart.DAO.GymCenterDAO;
import com.flipkart.DAO.GymCenterDAOInterface;
import com.flipkart.DAO.SlotsDAO;
import com.flipkart.DAO.SlotsDAOInterface;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.List;

public class GymCentreOperation {
    private SlotsDAOInterface slotsDAO=new SlotsDAO();
    private GymCenterDAOInterface gymCenterDAO=new GymCenterDAO();
    public GymCenter getCentre(Long centerId) {
        System.out.println("Getting centre with Centre Id: " + centerId);
        // Find Center with id as centreId
        GymCenter centre = new GymCenter();
        centre.setId(centerId);
        centre.setName("John Doe");
        return centre;
    }

    public GymCenter addCentre(GymCenter centre) {
        System.out.println("Add centre");
        //Add center to Database
        return centre;
    }

    public Slot addSlot(Long centreId, Slot slot) {
        //Add slot to the center
        System.out.println("Adding slot " + slot + " to Centre " + centreId);
        return slot;
    }

    public List<Slot> getAllSlots(Long centreId) {
        System.out.println("Getting all the slots for centre " + centreId);
        return slotsDAO.getAllSlotsByGymCenterId(centreId);
    }

    public Slot getSlotById(Long slotId){
        System.out.println("Getting slot with id " + slotId);
        return new Slot();
    }

    public GymCenter updateCentre(Long id, GymCenter centre) {
        System.out.println("Updating centre with Centre Id: " + centre.getId());
        return centre;
    }

    public void deleteCentre(Long id) {
        System.out.println("Deleting centre with Centre Id: " + id);
        return;
    }

    public List<GymCenter> getAllGymCenters() {
        System.out.println("Getting all the gym centers");
        return gymCenterDAO.getAllGymCenters();
    }
}
