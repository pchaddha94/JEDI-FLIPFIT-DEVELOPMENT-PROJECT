package com.flipkart.business;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.List;

public class CentreOperation {
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
        return new ArrayList<Slot>();
    }

    public GymCenter updateCentre(Long id, GymCenter centre) {
        System.out.println("Updating centre with Centre Id: " + centre.getId());
        return centre;
    }

    public void deleteCentre(Long id) {
        System.out.println("Deleting centre with Centre Id: " + id);
        return;
    }

    public void bookSlot(Long centreId, Long slotId) {
        System.out.println("Booking centre "+ centreId +" with Slot Id: " + slotId);
        return;
    }
}
