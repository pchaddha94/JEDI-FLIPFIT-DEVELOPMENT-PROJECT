/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.BookSlot;
import com.flipkart.bean.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class CustomerOperations {
     public Customer createCustomer (String customerName, String customerAddress, String customerEmail, String customerPhone , String customerPassword )
     {
    	 // create Customer 
    	 Customer customer = new Customer();
         customer.setCustomerName(customerName);
         customer.setCustomerAddress(customerAddress);
         customer.setCustomerPhone(customerPhone);
         customer.setPassword(customerPassword);
         customer.setCustomerEmailAddress( customerEmail);
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
         return true;
     }

     public Customer getCustomerByEmail(String email){
         Customer customer = new Customer();
         customer.setCustomerName("Flipfit Customer");
         customer.setCustomerAddress("Flipkart ETV");
         customer.setCustomerPhone("123456789");
         customer.setPassword("password");
         customer.setCustomerEmailAddress("flipkart.customer@flipkart.com");
         return customer;
     }
}
