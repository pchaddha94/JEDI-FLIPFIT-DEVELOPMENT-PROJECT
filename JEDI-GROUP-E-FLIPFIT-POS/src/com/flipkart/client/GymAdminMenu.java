package com.flipkart.client;

import com.flipkart.business.AdminOperation;
import com.flipkart.bean.GymAdmin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.List;
import java.util.Scanner;

public class GymAdminMenu {
    private AdminOperation adminOperation = new AdminOperation();
    private Scanner in = new Scanner(System.in);

    public boolean adminLogin(String email, String password) {
        if (adminOperation.validUser(email, password)) {
            System.out.println("Welcome " + email);
            System.out.println("Successfully logged in");
            GymAdmin admin = adminOperation.getAdminByEmail(email);
            AdminMainPage(admin.getAdminName());
        } else {
            System.out.println("Invalid username or password");
            return false;
        }
        return true;
    }

    public void approveGymOwner() {
        System.out.println("Enter the owner Id: ");
        Long owner_Id = in.nextLong();
        adminOperation.approveGymOwner(owner_Id);
    }

    public void approveGymCentre() {
        System.out.println("Enter the gym Id: ");
        Long gymId = in.nextLong();
        adminOperation.approveGymCenter(gymId);
    }

    public void viewPendingCenters() {
        List<GymCenter> gymDetails = adminOperation.viewPendingGymCentres();
        
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-16s %-13s %-16s %-16s %n", "Gym Id", "Name", "Email", "Approved");
        System.out.println("--------------------------------------------------------");

        for (GymCenter gym : gymDetails) {
            System.out.printf("%-16s %-16s %-16s %-16s %n",
                    gym.getId(), gym.getName(), gym.getEmail(), gym.isIs_approved() ? "Yes" : "No");
        }
        System.out.println("--------------------------------------------------------");
    }

    public void viewPendingGymOwners() {
        List<GymOwner> gymOwnerDetails = adminOperation.viewPendingGymOwners();

        System.out.printf("%-19s %-13s %-24s %-17s %n", "Email", "Name", "PAN Number", "Approved");
        for (GymOwner owner : gymOwnerDetails) {
            System.out.printf("%-19s %-13s %-24s %-17s %n",
                    owner.getOwnerEmailAddress(), owner.getOwnerName(), owner.getOwnerPanNum(),
                    owner.isApproved() ? "Yes" : "No");
        }
        System.out.println("**********************************");
    }

    public void AdminMainPage(String username) {
        System.out.println("Welcome " + username + ", Please Choose Your Option");
        boolean exit = false;

        while (!exit) {
            System.out.println("1. View All Pending Gym Owners");
            System.out.println("2. View All Pending Gym Centres");
            System.out.println("3. Approve Gym Owner");
            System.out.println("4. Approve Gym Centre");
            System.out.println("5. Edit Admin Profile");
            System.out.println("6. Exit");
            System.out.print("Enter number: ");

            int choice = in.nextInt();
            in.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> viewPendingGymOwners();
                case 2 -> viewPendingCenters();
                case 3 -> approveGymOwner();
                case 4 -> approveGymCentre();
                case 5 -> editAdminProfile();
                case 6 -> {
                    System.out.println("Exiting...");
                    exit = true;
                }
                default -> System.out.println("Invalid option, please try again.");
            }
        }
    }

    public void editAdminProfile() {
        GymAdmin admin = new GymAdmin();

        System.out.println("1. Edit name");
        System.out.println("2. Edit email address");
        System.out.println("3. Edit phone");

        int subOption = in.nextInt();
        in.nextLine(); // Consume newline

        switch (subOption) {
            case 1:
                System.out.print("Enter new name: ");
                admin.setAdminName(in.nextLine());
                System.out.println("Name changed successfully.");
                break;
            case 2:
                System.out.print("Enter new email address: ");
                admin.setAdminEmailAddress(in.nextLine());
                System.out.println("Email changed successfully.");
                break;
            case 3:
                System.out.print("Enter new phone number: ");
                admin.setPhone(in.nextLine());
                System.out.println("Contact number changed successfully.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void main(String[] args) {
        GymAdminMenu adminMenu = new GymAdminMenu();
        adminMenu.AdminMainPage("Admin");
    }
}
