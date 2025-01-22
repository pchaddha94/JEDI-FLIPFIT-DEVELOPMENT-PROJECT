package com.flipkart.client;
import com.flipkart.business.AdminOperation;
import com.flipkart.bean.GymAdmin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;

import java.util.List;
import java.util.Scanner;

public class GymAdminMenu {
    private AdminOperation adminOperation = new AdminOperation();

    public boolean adminLogin(String email, String password) {
        // TODO Auto-generated method stub
    	 if(adminOperation .validUser(email, password)) {
             System.out.println("Welcome " + email);
             System.out.println("Successfully logged in");
             GymAdmin gymAdmin = adminOperation.getAdminByEmail(email);
             Scanner in = new Scanner(System.in);
             try {
                 this.AdminPage(in); // Call the AdminMainPage method with the Scanner object
             } catch (Exception e) {
                 e.printStackTrace();
             }
         } else {
             System.out.println("Invalid username or password");
             return false;
         }
         return true;
//             gymOwnerClientMainPage(gymOwner.getOwnerName());
         }
         
 	

    
    

    public void approveGymOwner(Scanner in) {
        // TODO Auto-generated method stub
        System.out.println("Enter the owner Id: ");
        Long owner_Id = in.nextLong();
        adminOperation .approveGymOwner(owner_Id);
    }

    public void approveGymCentre(Scanner in) {
        // TODO Auto-generated method stub
        System.out.println("Enter the gym Id: ");
        Long gymId = in.nextLong();
        adminOperation .approveGymCenter(gymId);
    }

    public void ViewPendingCenters() {
        List<GymCenter> gymDetails = adminOperation .viewPendingGymCentres();
        System.out.println("------------------------------------------");
        System.out.printf("%-16s %-13s %-16s %-16s %n", "Gym Id", "Name", "Address", "Approved");
        System.out.println("--------------------------------------------------------");
        for (GymCenter gym : gymDetails) {
            System.out.printf("%-16s", gym.getId());
            System.out.printf("%-16s", gym.getName());
            System.out.printf("%-16s", gym.getEmail());
            System.out.printf("%-16s", gym.isIs_approved() ? "Yes" : "No");
            System.out.println("");
        }
        System.out.println("--------------------------------------------------------");
    }

    public void viewPendingGymOwners() {
        // TODO Auto-generated method stub
        List<GymOwner> gymOwnerDetails = adminOperation .viewPendingGymOwners();

        System.out.printf("%-19s %-13s %-24s %-17s %-15s %n", "Email", "Name", "GST Number", "Approved");
        for (GymOwner owner : gymOwnerDetails) {
            System.out.printf("%-16s\t", owner.getOwnerEmailAddress());
            System.out.printf("%-16s\t", owner.getOwnerName());
            System.out.printf("%-16s\t", owner.isApproved());
            System.out.printf("%-16s\t", owner.getOwnerPanNum());
            System.out.printf("%-16s\t", owner.isApproved() ? "Yes" : "No");
            System.out.println("");
        }
        System.out.println("**********************************");
    }

    public void AdminPage(Scanner in) throws Exception {
    	
    	boolean running=true;
        while (running) {
            System.out.println("1. View All Pending Gym Owners");
            System.out.println("2. View All Pending Gym Centres");
            System.out.println("3. Approve Gym Owner");
            System.out.println("4. Approve Gym Centre");
            System.out.println("5. Exit");
            System.out.print("Enter number: ");
            int choice = in.nextInt();
            switch (choice) {
                case 1:
                    viewPendingGymOwners();
                    break;
                case 2:
                    ViewPendingCenters();
                    break;
                case 3:
                    approveGymOwner(in);
                    break;
                case 4:
                    approveGymCentre(in);
                    break;
                case 5:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid number");
            }
        }
    }

    public static void AdminMenu() {
        GymAdminMenu gymAdminMenu = new GymAdminMenu(); // Create instance of GymAdminMenu
        GymAdmin admin = new GymAdmin();
        Scanner in = new Scanner(System.in);
        int option;

        System.out.println("1. Approve Gym Owner Registration");
        System.out.println("2. Approve Gym Center Registration");
        System.out.println("3. View List of Pending GymsCenter");
        System.out.println("4. View List of Pending GymOwner ");
        System.out.println("5. Edit Admin Profile");
        System.out.println("6. Exit");
        option = in.nextInt();

        switch (option) {
            case 1:
                gymAdminMenu.approveGymOwner(in); // Approve Gym Owner
                break;
            case 2:
                gymAdminMenu.approveGymCentre(in); // Approve Gym Center
                break;
            case 3:
                gymAdminMenu.ViewPendingCenters(); // View Pending Gym Centers
                break;
            case 4:
                gymAdminMenu.viewPendingGymOwners(); // View Pending Gym Owners
                break;
            case 5:
                System.out.println("1. Edit name");
                System.out.println("2. Edit email address");
                System.out.println("3. Edit phone");

                int subOption = in.nextInt();
                in.nextLine(); // Consume newline

                if (subOption == 1) {
                    System.out.print("Enter new name: ");
                    String name = in.nextLine();
                    admin.setAdminName(name);
                    System.out.println("Name changed successfully");
                }

                if (subOption == 2) {
                    System.out.print("Enter new email address: ");
                    String email = in.nextLine();
                    admin.setAdminEmailAddress(email);
                    System.out.println("Email changed successfully");
                }

                if (subOption == 3) {
                    System.out.print("Enter new phone number: ");
                    String phone = in.nextLine();
                    admin.setPhone(phone);
                    System.out.println("Contact number changed successfully");
                }
                break;

            case 6:
                System.out.println("Exit");
                break;

            default:
                System.out.println("Invalid option");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        AdminMenu();
    }
}
