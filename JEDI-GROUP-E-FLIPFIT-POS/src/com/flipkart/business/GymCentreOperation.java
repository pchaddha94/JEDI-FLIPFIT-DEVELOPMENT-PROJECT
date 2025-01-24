/**
 * GymCentreOperation class manages gym center operations,
 * including adding, retrieving, updating, and deleting gym centers and slots.
 */
package com.flipkart.business;

import com.flipkart.DAO.GymCenterDAO;
import com.flipkart.DAO.GymCenterDAOInterface;
import com.flipkart.DAO.SlotsDAO;
import com.flipkart.DAO.SlotsDAOInterface;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GymCentreOperation {
    
    // DAO instances to interact with the database
    private SlotsDAOInterface slotsDAO = new SlotsDAO();
    private GymCenterDAOInterface gymCenterDAO = new GymCenterDAO();
    
    /**
     * Retrieves a gym center by its ID.
     * 
     * @param centerId ID of the gym center
     * @return GymCenter object with the specified ID
     */
    public GymCenter getCentre(Long centerId) {
        System.out.println("Getting centre with Centre Id: " + centerId);
        // Find Center with id as centreId
        GymCenter centre = new GymCenter();
        centre.setId(centerId);
        centre.setName("John Doe");
        return centre;
    }

    /**
     * Adds a new gym center to the system.
     * 
     * @param centre GymCenter object to be added
     * @return Added GymCenter object
     */
    public GymCenter addCentre(GymCenter centre) {
        System.out.println("Add centre");
        gymCenterDAO.addGymCenter(centre);
        return centre;
    }

    /**
     * Adds a new slot to a specified gym center.
     * 
     * @param centreId ID of the gym center
     * @param slot Slot object to be added
     * @return Added Slot object
     */
    public Slot addSlot(Long centreId, Slot slot) {
        slotsDAO.addSlot(slot);
        return slot;
    }

    /**
     * Retrieves all slots for a given gym center.
     * 
     * @param centreId ID of the gym center
     * @return List of Slot objects associated with the gym center
     */
    public List<Slot> getAllSlots(Long centreId) {
        System.out.println("Getting all the slots for centre " + centreId);
        return slotsDAO.getAllSlotsByGymCenterId(centreId);
    }

    /**
     * Retrieves a slot by its ID.
     * 
     * @param slotId ID of the slot
     * @return Slot object with the specified ID
     */
    public Slot getSlotById(Long slotId){
        System.out.println("Getting slot with id " + slotId);
        return new Slot();
    }

    /**
     * Updates a gym center with new details.
     * 
     * @param id ID of the gym center to update
     * @param centre GymCenter object containing updated details
     * @return Updated GymCenter object
     */
    public GymCenter updateCentre(Long id, GymCenter centre) {
        System.out.println("Updating centre with Centre Id: " + centre.getId());
        return centre;
    }

    /**
     * Deletes a gym center by its ID.
     * 
     * @param id ID of the gym center to delete
     */
    public void deleteCentre(Long id) {
        System.out.println("Deleting centre with Centre Id: " + id);
    }

    /**
     * Retrieves all gym centers from the system.
     * 
     * @return List of all GymCenter objects
     */
    public List<GymCenter> getAllGymCenters() {
        System.out.println("Getting all the gym centers");
        return gymCenterDAO.getAllGymCenters();
    }

    /**
     * Retrieves all gym centers owned by a specific gym owner.
     * 
     * @param gymOwnerId ID of the gym owner
     * @return List of GymCenter objects owned by the specified owner
     */
    public List<GymCenter> getAllGymCentersByGymOwnerId(Long gymOwnerId) {
        System.out.println("Getting all the gym centers by gym owner id");
        List<GymCenter> gymCenters = getAllGymCenters();
        List<GymCenter> gymCentersByGymOwnerId = new ArrayList<>();
        for(GymCenter gymCenter : gymCenters){
            if(Objects.equals(gymCenter.getGymOwnerId(), gymOwnerId)){
                gymCentersByGymOwnerId.add(gymCenter);
            }
        }
        return gymCentersByGymOwnerId;
    }
}
