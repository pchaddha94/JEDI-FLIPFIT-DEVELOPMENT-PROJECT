package com.flipkart.business;

import com.flipkart.bean.Centre;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.List;

public class CentreOperation {
    public Centre getCentre(Long centreId) {
        System.out.println("Getting centre with Centre Id: " + centreId);
        // Find Centre with id as centreId
        Centre centre = new Centre();
        centre.setId(centreId);
        centre.setName("John Doe");
        return centre;
    }

    public Centre addCentre(Centre centre) {
        System.out.println("Add centre");
        //Add centre to Database
        return centre;
    }

    public Slot addSlot(Long centreId, Slot slot) {
        //Add slot to the centre
        System.out.println("Adding slot " + slot + " to Centre " + centreId);
        return slot;
    }

    public List<Slot> getAllSlots(Long centreId) {
        System.out.println("Getting all the slots for centre " + centreId);
        return new ArrayList<Slot>();
    }

    public Centre updateCentre(Long id, Centre centre) {
        System.out.println("Updating centre with Centre Id: " + centre.getId());
        return centre;
    }

    public void deleteCentre(Long id) {
        System.out.println("Deleting centre with Centre Id: " + id);
        return;
    }
}
