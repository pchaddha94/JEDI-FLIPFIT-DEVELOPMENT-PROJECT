package com.flipkart.business;

import com.flipkart.DAO.AdminDao;
import com.flipkart.bean.*;
import com.flipkart.exceptions.UserNotFoundException;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class AdminOperation {

    // Lists to store pending gym owners and gym centers
    private List<GymOwner> pendinGymOwnerList = new ArrayList<>();
    private List<GymCenter> pendinGymCentreList = new ArrayList<>();
    
    // DAO instance to handle database operations
    public AdminDao adminDao = new AdminDao();
    
    /**
     * Creates a new GymAdmin object with the provided details.
     * @param adminName Name of the admin
     * @param adminEmail Email address of the admin
     * @param adminPhone Contact number of the admin
     * @param password Password for admin login
     * @return A GymAdmin object containing the given details
     */
    public GymAdmin createAdmin( String adminName, String adminEmail, String adminPhone, String password) {
        GymAdmin admin = new GymAdmin();
        admin.setAdminName(adminName);
        admin.setAdminEmailAddress(adminEmail);
        admin.setPhone(adminPhone);
        admin.setPassword(password);
        adminDao.addAdmin(admin);
        return admin;
    }

    // 1 - Approve requests
    // 2 - View pending and approved requests
    
    /**
     * Approves a gym owner registration request.
     * @param ownerId Unique ID of the gym owner
     * @return true if approved successfully
     */
    public boolean approveGymOwner(long ownerId) {
        System.out.println("Owner with ID: " + ownerId + " is approved");
        adminDao.approveGymOwnerRegistration(ownerId);
        return true;
    }
    
    /**
     * Approves a gym center registration request.
     * @param centerId Unique ID of the gym center
     * @return true if approved successfully
     */
    public boolean approveGymCenter(long centerId) {
        adminDao.approveGymRegistration(centerId);
        System.out.println("Center with ID: " + centerId + " is approved");
        return true;
    }
    
    /**
     * Retrieves a list of pending gym center registration requests.
     * @return List of GymCenter objects that are pending approval
     */
    public List<GymCenter> viewPendingGymCentres() {
        return adminDao.viewPendingGymRequests();
    }
    
    /**
     * Retrieves a list of pending gym owner registration requests.
     * @return List of GymOwner objects that are pending approval
     */
    public List<GymOwner> viewPendingGymOwners() {
        return adminDao.viewPendingGymOwnerRequests();
    }
    
    /**
     * Retrieves a list of approved gym owners.
     * @return List of GymOwner objects that have been approved
     */
    public List<GymOwner> viewApprovedGymOwners() {
        return adminDao.viewAllApprovedGymOnwers();
    }
    
    /**
     * Retrieves a list of approved gym centers.
     * @return List of GymCenter objects that have been approved
     */
    public List<GymCenter> viewApprovedGymCentres() {
        return adminDao.viewAllApprovedGyms();
    }
    
    /**
     * Validates an admin user's login credentials.
     * @param adminEmail Email address of the admin
     * @param password Password entered by the admin
     * @return true if credentials are valid (TODO: Implement verification logic)
     */
    public boolean validUser(String adminEmail, String password) throws UserNotFoundException {
        GymAdmin gymAdmin = getAdminByEmail(adminEmail);
        if(Objects.isNull(gymAdmin)) {
            throw new UserNotFoundException();
        }
        return Objects.nonNull(gymAdmin.getPassword()) && Objects.equals(gymAdmin.getPassword(), password);
    }
    
    /**
     * Retrieves admin details based on email.
     * @param email Email address of the admin
     * @return A GymAdmin object with pre-set details (TODO: Fetch from database)
     */
    public GymAdmin getAdminByEmail(String email) {
        return adminDao.getAdminByEmail(email);
    }
}
