package com.flipkart.client;

import com.flipkart.bean.Customer;
import com.flipkart.bean.Slot;
import com.flipkart.business.GymCentreOperation;
import com.flipkart.business.CustomerOperations;

import java.util.List;
import java.util.Scanner;

public class GymCustomerMenu {
    private  
    private GymCentreOperation centreOperation = new GymCentreOperation();

    private Scanner scanner = new Scanner(System.in);

    public boolean customerLogin(String email, String password) {
        if(customerOperations.validUser(email, password)) {
            System.out.println("Welcome " + email);
            System.out.println("Successfully logged in");
            Customer customer = customerOperations.getCustomerByEmail(email);
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

        Customer customer = customerOperations.createCustomer(username, address,email,phoneNumber,password);
        customerMainPage(customer.getCustomerName());
    }

    public void customerMainPage(String userName) {
        System.out.println("Welcome " + userName + ". Please choose your option: ");
        while(true){
            System.out.println("1. View available slots.\n2.Book slots.\n3.View Booking.\n4.Cancel Booking.\n5.Go back to main menu.");
            int option = scanner.nextInt();
            switch(option){
                case 1:
                    System.out.println("Please enter gym centre.");
                    String gymCentreName = scanner.next();
                    List<Slot> slots = centreOperation.getAllSlots(1L);
                    System.out.println("Available slots:\n1. Slot 1\n2. Slot 2\n3. Slot 3");
                    break;
                case 2:
                    System.out.println("Please enter gym centre\n");
                    String gymCentre = scanner.next();

                    System.out.println("Please enter slot");
                    String slotName = scanner.next();

                    centreOperation.bookSlot(1L,1L);
                    break;
                case 3:
                    System.out.println(customerOperations.viewAllBooking(1L));
                    break;
                case 4:
                    System.out.println("Please enter slot");
                    String slot = scanner.next();
                    customerOperations.cancelBookedSlot(userName,slot);
                    System.out.println("Slot cancelled");
                    break;
                case 5:
                    System.out.println("Returning to main menu");
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }
    
    
}
