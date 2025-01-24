package com.flipkart.client;

import com.flipkart.DAO.GymCustomerDAO;
import com.flipkart.DAO.GymCustomerDAOInterface;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.Slot;
import com.flipkart.business.GymCentreOperation;
import com.flipkart.business.CustomerOperations;
import com.flipkart.business.FeedbackOperation;

import java.util.List;
import java.util.Scanner;

public class GymCustomerMenu {
   
    private GymCentreOperation centreOperation = new GymCentreOperation();
    private CustomerOperations customerOperation = new CustomerOperations();
    private GymCustomerDAOInterface gymCustomerDAO = new GymCustomerDAO();
    private Scanner scanner = new Scanner(System.in);

    public boolean customerLogin(String email, String password) {
        if(customerOperation.validUser(email, password)) {
            System.out.println("Welcome " + email);
            System.out.println("Successfully logged in");
            Customer customer = gymCustomerDAO.getCustomerByEmail(email);
            customerMainPage(customer.getCustomerName());
        }
        else{
            System.out.println("Invalid username or password");
            return false;
        }
        return  true;
    }

    public void registerCustomer() {

        System.out.println("Please enter your username");
        String username = scanner.next();

        System.out.println("Please enter your email address");
        String email = scanner.next();

        System.out.println("Please enter your password");
        String password = scanner.next();

        System.out.println("Please enter your phone number");
        String phoneNumber = scanner.next();

        System.out.println("Please enter your address");
        String address = scanner.next();

        Customer customer = customerOperation.createCustomer(username, address,email,phoneNumber,password);
        customerMainPage(customer.getCustomerName());
    }

    public void customerMainPage(String userName) {
        System.out.println("Welcome " + userName + ". Please choose your option: ");
        Customer customer = gymCustomerDAO.getCustomerByEmail(userName);
        while(true){
            System.out.println("1. View available center.\n2. View available slots.\n3.Book slots.\n4.View Booking.\n5.Cancel Booking.\n6.Give Feedback \n7.Go back to main menu.");
            int option = scanner.nextInt();
            switch(option){
                case 1:
                    List<GymCenter> gymCenters = centreOperation.getAllGymCenters();
                    System.out.println();
                    gymCenters.forEach(gymCenter -> {
                        System.out.println("Gym center id: " + gymCenter.getId());
                        System.out.println("Gym center name: " + gymCenter.getName());
                        System.out.println("Gym center location: " + gymCenter.getLocation());
                        System.out.println("\n");
                    });
                    break;
                case 2:
                    System.out.println("Please enter gym centre ID");
                    Long centreId = scanner.nextLong();
                    List<Slot> slots = centreOperation.getAllSlots(centreId);
                    slots.forEach(slot -> {
                        System.out.println("Slot id: "+ slot.getSlotID());
                        System.out.println("Center id of the slot: "+slot.getCentreId());
                        System.out.println("Slot timings: "+slot.getSlotTimings());
                        System.out.println("Price: "+slot.getPrice());
                        System.out.println("\n");
                    });
                    break;
                case 3:
                    System.out.println("Please enter slot Id");
                    Long slotId = scanner.nextLong();

                    customerOperation.bookSlot(customer.getCustomerId(),slotId);
                    break;
                case 4:
                    System.out.println(customerOperation.viewAllBooking(1L));
                    break;
                case 5:
                    System.out.println("Please enter slot");
                    String slot = scanner.next();
                    customerOperation.cancelBookedSlot(userName,slot);
                    System.out.println("Slot cancelled");
                    break;
                case 7:
                    System.out.println("Returning to main menu");
                    return;
                case 6:
                	FeedbackOperation feedbackOperation = new FeedbackOperation();
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("Enter User ID:");
                    Long userId = scanner.nextLong();

                    System.out.println("Enter Centre ID:");
                    centreId = scanner.nextLong();

                    scanner.nextLine(); // Consume the newline character left by nextLong()

                    System.out.println("Enter Comments:");
                    String comments = scanner.nextLine();

                    System.out.println("Enter Rating (1-5):");
                    int rating = scanner.nextInt();
                    
                    if (rating < 1 || rating > 5) {
                        System.out.println("Invalid rating! Please enter a value between 1 and 5.");
                    } else {
                        feedbackOperation.addFeedback(userId, comments, rating, centreId);
                    }
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
    
    
}
