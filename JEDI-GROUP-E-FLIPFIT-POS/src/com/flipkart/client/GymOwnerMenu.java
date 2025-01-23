package com.flipkart.client;

import com.flipkart.DAO.UserDao;
import com.flipkart.bean.Customer;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.business.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.utils.*;
import java.util.Scanner; 

public class GymOwnerMenu {
	
	private GymOwnerOperation gymOwnerOperations=new GymOwnerOperation();
	private UserDao userDao=new UserDao();
	Scanner scanner = new Scanner(System.in);
	
	
	public boolean gymOwnerLogin(String email, String password) {
        if(gymOwnerOperations.validUser(email, password)) {
            System.out.println("Welcome " + email);
            System.out.println("Successfully logged in");
            GymOwner gymOwner = gymOwnerOperations.getGymOwnerByEmail(email);
            gymOwnerClientMainPage(gymOwner.getOwnerName(),gymOwner.getOwnerId());
//            gymOwnerClientMainPage(gymOwner.getOwnerName());
        }
        else{
            System.out.println("Invalid username or password");
            return false;
        }
        return  true;
    }
	

	
    public void register() {
        System.out.println("Enter your Username");
        String userName = scanner.next();

        System.out.println("Enter your Password");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();
        
        System.out.println("Enter your Phone");
        String phone = scanner.next();

        System.out.println("Enter your PAN Number");
        String panNumber = scanner.next();

        System.out.println("Enter your address");
        String address = scanner.next();

        System.out.println("Register successful");
        
        GymOwner gymOwner=gymOwnerOperations.createGymOwner( userName, email,password, phone, panNumber, true, address);
    }
    public void gymOwnerClientMainPage(String gymOwnerName, Long ownerId) {
    	while(true) {
    		System.out.println("" +
                    "0. View all Bookings\n" +
                    "1. Add new Gym Center\n" +
                    "2. Add Slots to a Gym Centre\n" +
                    "3.Remove centre owned\n"+
                    "4.Remove slot\n"+
                    "5. Go Back to Previous Menu\n"
            );
    		int choice = scanner.nextInt();
			scanner.nextLine();
    		switch(choice) {
    			case 0:
    				System.out.println("All bookings displayed\n");
    				break;
    			case 1:
    				System.out.println("Enter the Gym Name");
    				String name = scanner.nextLine();

//					System.out.println(name);

    				System.out.println("Enter Gym center Email ID");
    				String email = scanner.nextLine();
//					System.out.println(email);
    				System.out.println("Enter the Gym Location");
    				String location = scanner.nextLine();
//					System.out.println(location);

					GymCenter gymCenter = new GymCenter();
					gymCenter.setName(name);
					gymCenter.setEmail(email);
					gymCenter.setLocation(location);
					gymCenter.setGymOwnerId(ownerId);
					gymCenter.setIs_approved(false);
					gymOwnerOperations.addCentre(gymCenter);
    				System.out.println("Centre added successfully\n");
    				break;
    			case 2:
    				System.out.println("Enter the Centre id");
    				Long centreId = scanner.nextLong();
    				System.out.println("Enter Your Email ID");
    				String slotTimings = scanner.nextLine();
    				scanner.nextLine();
    				System.out.println("Enter the Price for the slot");
    				String price = scanner.nextLine();
    				System.out.println("Slot added successfully");
    				break;
    			case 3:
    				System.out.println("Enter the centre id");
    				Long centerId = scanner.nextLong();
    				System.out.println("Centre removed successfully\n");
    				break;
    			case 4:
    				System.out.println("Enter the Slot id");
    				Long slotId = scanner.nextLong();
    				System.out.println("Slot removed successfully\n");
    				break;
    			case 5:
    				System.out.println("Back to menu successful\n");
    				return;
    			default:
                    System.out.println("Invalid Option selected");
                    break;
    		}
    	}
    }
}
