package com.flipkart.client;

import java.util.Scanner;

import com.flipkart.utils.UserRole;
//
//import com.flipkart.exceptions.LoginFailedException;

public class FlipFitApplication {
	public static Scanner scanner = new Scanner(System.in);
    private static GymAdminMenu adminClient = new GymAdminMenu();
    private static GymCustomerMenu customerClient = new GymCustomerMenu();
    private static GymOwnerMenu gymOwnerClient = new GymOwnerMenu();


    private static void mainPage(){
        System.out.println("1. Login\n2. Registration\n3. Change Password\n4. Exit");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                login();
                break;
            case 2:
                registration();
                break;
            case 4:
                System.out.println("Thanks for visiting!");
                return;
            default:
                System.out.println("Invalid choice selected");
                break;
        }
        mainPage();
    }

    private static void login(){
        try {
            System.out.println("Enter your Role");
            UserRole role = UserRole.valueOf(scanner.next().toUpperCase());

            System.out.println("Enter your Username");
            String userName = scanner.next();

            System.out.println("Enter your Password");
            String password = scanner.next();

            switch (role){
                case ADMIN:
                    adminClient.adminLogin(userName,password);
                    break;
                case OWNER:
                    gymOwnerClient.gymOwnerLogin(userName,password);
                    break;
                case CUSTOMER:
                    customerClient.customerLogin(userName,password);
                    break;
                default:
                    System.out.println("Invalid Option Selected");
                    break;
            }
        }catch (Exception e){  //TODO change exceptions
            System.out.println("Invalid Option Selected");
        }
    }

    private static void registration(){
        try {
            System.out.println("Enter your role");
            UserRole role = UserRole.valueOf(scanner.next().toUpperCase());

            switch (role){
                case ADMIN:
                    System.out.println("Admin is already registered");
                    mainPage();
                    break;
                case CUSTOMER:
                    customerClient.registerCustomer();
                    break;
                case OWNER:
                    gymOwnerClient.register();
                    break;
                default:
                    System.out.println("Invalid Option Selected");
                    break;
            }
        }catch (Exception e){  //TODO
            System.out.println("Invalid Option Selected");
        }
    }
    public static void main(String[] args) {
        System.out.println("Welcome to FlipFit Application!\n");
        mainPage();
    }
}