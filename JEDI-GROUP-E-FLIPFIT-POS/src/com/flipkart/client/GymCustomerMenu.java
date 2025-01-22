package com.flipkart.client;

import com.flipkart.bean.Customer;
import com.flipkart.business.CustomerOperations;

import java.util.Scanner;

public class GymCustomerMenu {
    private CustomerOperations customerOperations = new CustomerOperations();

    Scanner scanner = new Scanner(System.in);

    public boolean customerLogin(String email, String password) {
        if(customerOperations.validUser(email, password)) {
            System.out.println("Welcome " + email);
            System.out.println("Successfully logged in");
            customerMainPage(email);
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
        customerMainPage(email);
    }

    public void customerMainPage(String email){

    }
}
