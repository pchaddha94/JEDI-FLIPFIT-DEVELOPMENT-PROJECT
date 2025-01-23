/**
 * 
 */
package com.flipkart.business;

import com.flipkart.DAO.GymCustomerDAO;
import com.flipkart.DAO.GymCustomerDAOInterface;
import com.flipkart.bean.BookSlot;
import com.flipkart.bean.Customer;

import java.util.List;
import java.util.Objects;

/**
 * 
 */
public class CustomerOperations {

    private GymCustomerDAOInterface gymCustomerDAO = new GymCustomerDAO();
     public Customer createCustomer (String customerName, String customerAddress, String customerEmail, String customerPhone , String customerPassword )
     {
    	 // create Customer 
    	 Customer customer = new Customer();
         customer.setCustomerName(customerName);
         customer.setCustomerAddress(customerAddress);
         customer.setCustomerPhone(customerPhone);
         customer.setPassword(customerPassword);
         customer.setCustomerEmailAddress( customerEmail);

         gymCustomerDAO.addCustomer(customer);
         return customer;
     }
     public void bookSlot(String Gym)
     {
    	 // Book slot
    	 System.out.println("Book Slot");
    	 return;
     }
     public void searchGym(String location)
     {
    	 // search Gym
    	 System.out.println("Search Gym");
    	 return;
     }
     public List<BookSlot> viewAllBooking(Long customerId)
     {
    	 // view All Booking
    	 System.out.println("view All Booking");
    	 return null;
     }
     public void cancelBookedSlot(String userName,  String slot)
     {
    	// cancel slot
    	 System.out.println("Cancel Slot");
    	 return ;
     }
     public void updateSlot()
     {
    	 //Update slot
    	 System.out.println("Update Slot");
    	 return ;
     }
     public void editCustomerProfile(Long customerId)
     {
    	 // Edit Customer Details
    	 System.out.println("Edit Customer Details");
    	 return;
     }
     public boolean validUser(String email, String password){
         Customer customer = gymCustomerDAO.getCustomerByEmail(email);
         return Objects.equals(customer.getPassword(), password);
     }
}
