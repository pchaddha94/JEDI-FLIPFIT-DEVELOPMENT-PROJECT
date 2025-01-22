package com.flipkart.client;

import com.flipkart.bean.FlipFitGymCenter;
import com.flipkart.bean.FlipFitSlot;
import com.flipkart.business.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.flipkart.utils.Util.*;
import java.util.Scanner; 

public class GymOwnerMenu {
	Scanner scanner = new Scanner(System.in);
	public boolean gymOwnerLogin(String userName, String password) {
		System.out.println("Successfully logged in");
		return true;
	}
    public void register() {
        System.out.println("Enter your Username");
        String userName = scanner.next();

        System.out.println("Enter your Password");
        String password = scanner.next();

        System.out.println("Enter your Email");
        String email = scanner.next();

        System.out.println("Enter your PAN Number");
        String panNumber = scanner.next();

        System.out.println("Enter your Card Number");
        String cardNumber = scanner.next();

        System.out.println("Register successful");
    }
    public void gymOwnerClientMainPage(String gymOwnerId) {
    	while(true) {
    		System.out.println("" +
                    "0. View all Bookings\n" +
                    "1. Add new Gym Center\n" +
                    "2. Add Slots to a Gym Centre\n" +
                    "3.Remove centre owned"+
                    "4.Remove slot"+
                    "5. Go Back to Previous Menu"
            );
    		int choice = scanner.nextInt();
    		switch(choice) {
    			case 0:
    				System.out.println("All bookings displayed");
    				break;
    			case 1:
    				System.out.println("Enter the Gym Name");
    				String name = scanner.nextLine();
    				System.out.println("Enter Your Email ID");
    				String email = scanner.nextLine();
    				System.out.println("Enter the Gym Location");
    				String location = scanner.nextLine();
    				System.out.println("Centre added successfully");
    				break;
    			case 2:
    				System.out.println("Enter the Centre id");
    				Long centreId = scanner.nextLong();
    				System.out.println("Enter Your Email ID");
    				String slotTimings = scanner.nextLine();
    				System.out.println("Enter the Price for the slot");
    				String price = scanner.nextLine();
    				System.out.println("Slot added successfully");
    				break;
    			case 3:
    				System.out.println("Enter the centre id");
    				Long centerId = scanner.nextLong();
    				System.out.println("Centre removed successfully");
    				break;
    			case 4:
    				System.out.println("Enter the Slot id");
    				Long slotId = scanner.nextLong();
    				System.out.println("Slot removed successfully");
    				break;
    			case 5:
    				System.out.println("Back to menu successful");
    				return;
    			default:
                    System.out.println("Invalid Option selected");
                    break;
    		}
    	}
    }
}
