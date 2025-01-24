/**
 * CustomerOperations class handles various customer-related functionalities
 * such as creating customers, booking slots, searching gyms, and updating profiles.
 */
package com.flipkart.business;

import com.flipkart.DAO.BookSlotDAO;
import com.flipkart.DAO.BookSlotDAOInterface;
import com.flipkart.DAO.GymCustomerDAO;
import com.flipkart.DAO.GymCustomerDAOInterface;
import com.flipkart.bean.BookSlot;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.exceptions.UserNotFoundException;
import com.flipkart.utils.BookingStatusType;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

public class CustomerOperations {

    // DAO instances to interact with the database
    private GymCustomerDAOInterface gymCustomerDAO = new GymCustomerDAO();
    private BookSlotDAOInterface bookSlotDAO = new BookSlotDAO();
    
    /**
     * Creates a new Customer with the provided details and stores it in the database.
     * @param customerName Name of the customer
     * @param customerAddress Address of the customer
     * @param customerEmail Email address of the customer
     * @param customerPhone Contact number of the customer
     * @param customerPassword Password for the customer account
     * @return The created Customer object
     */
    public Customer createCustomer(String customerName, String customerAddress, String customerEmail, String customerPhone, String customerPassword) {
        Customer customer = new Customer();
        customer.setCustomerName(customerName);
        customer.setCustomerAddress(customerAddress);
        customer.setCustomerPhone(customerPhone);
        customer.setPassword(customerPassword);
        customer.setCustomerEmailAddress(customerEmail);
        
        gymCustomerDAO.addCustomer(customer);
        return customer;
    }

    /**
     * Books a slot for a customer.
     * @param customerId ID of the customer
     * @param slotId ID of the slot to be booked
     */
    public void bookSlot(Long customerId, Long slotId) {
        BookSlot bookSlot = new BookSlot();
        bookSlot.setCustomerId(customerId);
        bookSlot.setSlotId(slotId);
        bookSlot.setBookingStatus(BookingStatusType.CONFIRMED);
        bookSlot.setBookingDate(new Date(System.currentTimeMillis()));
        bookSlotDAO.addCustomerBooking(bookSlot);
    }

    /**
     * Searches for gyms based on the provided location.
     * @param location Location to search gyms in
     */
    public void searchGym(String location) {
        System.out.println("Search Gym");
    }

    /**
     * Retrieves all booking details for a specific customer.
     * @param customerId ID of the customer
     * @return List of BookSlot objects representing the customer's bookings
     */
    public List<BookSlot> viewAllBooking(Long customerId) {
        return bookSlotDAO.getCustomerBookings(customerId);
    }

    /**
     * Cancels a booked slot.
     * @param userName Name of the customer
     * @param slot Slot to be canceled
     */
    public void cancelBookedSlot(String userName, String slot) {
        System.out.println("Cancel Slot");
    }

    /**
     * Updates an existing booked slot.
     */
    public void updateSlot() {
        System.out.println("Update Slot");
    }

    /**
     * Edits customer profile details.
     * @param customerId ID of the customer
     */
    public void editCustomerProfile(Long customerId) {
        System.out.println("Edit Customer Details");
    }

    /**
     * Validates if a user exists with the given email and password.
     * @param email Email of the customer
     * @param password Password entered
     * @return true if valid user, false otherwise
     */
    public boolean validUser(String email, String password) throws UserNotFoundException {
        Customer customer = gymCustomerDAO.getCustomerByEmail(email);
        if(Objects.isNull(customer)) {
            throw new UserNotFoundException();
        }

        return Objects.isNull(customer.getPassword()) && !Objects.equals(customer.getPassword(), password);
    }

    /**
     * Retrieves a list of all gym centers.
     * @return List of GymCenter objects
     */
    public List<GymCenter> viewAllGymCenter() {
        return null;
    }
}
