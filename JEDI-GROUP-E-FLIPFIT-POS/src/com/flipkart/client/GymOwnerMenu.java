package com.flipkart.client;

import com.flipkart.DAO.*;
import com.flipkart.bean.*;
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
	private GymCentreOperation gymCentreOperation=new GymCentreOperation();
	private FeedbackDAOInterface feedbackDao=new FeedbackDAO();
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

        System.out.println("Register successful\n");
        
        GymOwner gymOwner=gymOwnerOperations.createGymOwner( userName, email,password, phone, panNumber, true, address);
    }
    public void gymOwnerClientMainPage(String gymOwnerName, Long ownerId) {
    	while(true) {
    		System.out.println("" +
					"0. Get all gym center\n" +
                    "1. Add new Gym Center\n" +
                    "2. Add Slots to a Gym Centre\n" +
                    "3. Remove centre owned\n"+
                    "4. Remove slot\n"+
					"5. View feedbacks\n"+
                    "6. Go Back to Previous Menu\n"
            );
    		int choice = scanner.nextInt();
			scanner.nextLine();
    		switch(choice) {
				case 0:
					List<GymCenter> gymCenters = gymCentreOperation.getAllGymCentersByGymOwnerId(ownerId);
					gymCenters.forEach(gymCenter -> {
						System.out.println("Gym Center name: "+ gymCenter.getName());
						System.out.println("Gym email id: "+ gymCenter.getEmail());
						System.out.print("Approval status: "+gymCenter.isIs_approved());
						System.out.println("Center location: "+gymCenter.getLocation());
						System.out.println("\n");
					});
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
					scanner.nextLine();
    				System.out.println("Enter Your timings in HH:MM format");
    				String slotTimings = scanner.nextLine();
    				System.out.println("Enter the Price for the slot");
    				String price = scanner.nextLine();
					Slot slot = new Slot();
					slot.setCentreId(centreId);
					slot.setSlotTimings(slotTimings);
					slot.setPrice(Integer.parseInt(price));
					gymOwnerOperations.addSlot(slot);
					System.out.println("Slot added successfully\n");
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
					System.out.println("Enter gym center id");
					centerId = scanner.nextLong();
					scanner.nextLine();
					List<Feedback> feedbacks = feedbackDao.getAllFeedbackOfGymCenter(centerId);

					for(Feedback feedback : feedbacks) {
						System.out.println("Feedback Id: " + feedback.getFeedbackId());
						System.out.println("User id: "+feedback.getUserId());
						System.out.println("Rating: "+feedback.getRating());
						System.out.print(("Comment: "+feedback.getComments()));
						System.out.println("\n");
					}
					break;
    			case 6:
    				System.out.println("Back to menu successful\n");
    				return;
    			default:
                    System.out.println("Invalid Option selected");
                    break;
    		}
    	}
    }
}
