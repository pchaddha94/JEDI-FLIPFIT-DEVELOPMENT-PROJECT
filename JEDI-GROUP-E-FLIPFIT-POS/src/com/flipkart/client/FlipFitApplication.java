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
            case 3:
                changePassword();
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
            System.out.println("Enter your Username");
            String userName = scanner.next();

            System.out.println("Enter your Password");
            String password = scanner.next();

            System.out.println("Enter your Role");
            UserRole role = UserRole.valueOf(scanner.next().toUpperCase());

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
                    adminClient.adminRegister();
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

    private static void changePassword(){
        try{
            System.out.println("Enter your username");
            String userName = scanner.next();
            System.out.println("Enter your old password");
            String oldPassword = scanner.next();
            System.out.println("Enter your new password");
            String newPassword = scanner.next();

            while(oldPassword.equals(newPassword)){
                System.out.println("This is same as old password, please enter a new password");
                newPassword = scanner.next();
            }

            System.out.println("Enter your new password again");
            String newPasswordAgain = scanner.next();

            while (!newPassword.equals(newPasswordAgain)){
                System.out.println("Passwords do not match, please try again");
                System.out.println("Enter your new password");
                newPassword = scanner.next();
                System.out.println("Enter your new password again");
                newPasswordAgain = scanner.next();
            }
            System.out.println("Password changed successfully\n");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to FlipFit Application!\n");
        mainPage();
    }
}