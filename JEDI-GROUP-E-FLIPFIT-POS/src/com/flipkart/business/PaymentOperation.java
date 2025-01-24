package com.flipkart.business;

import com.flipkart.bean.*;
import com.flipkart.DAO.PaymentDAO;
import com.flipkart.DAO.PaymentDaoInterface;
import com.flipkart.utils.PaymentStatusType;
import com.flipkart.utils.PaymentType;
import java.util.Scanner;

public class PaymentOperation {
    
	
    public void processPayment(Customer customer, Slot slot) {
        if (!checkSlotAvailability(slot)) {
            System.out.println("Slot not available. Adding to waiting list.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Select payment method:");
        System.out.println("1. UPI");
        System.out.println("2. Credit Card");
        System.out.println("3. Debit Card");

        int choice = scanner.nextInt();
        
        boolean paymentSuccess = false;
        switch (choice) {
            case 1:
                paymentSuccess = processUPIPayment();
                break;
            case 2:
                paymentSuccess = processCardPayment("Credit");
                break;
            case 3:
                paymentSuccess = processCardPayment("Debit");
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        if (paymentSuccess) {
            System.out.println("Payment successful!");
            bookSlot(customer, slot);
        } else {
            System.out.println("Payment failed!");
        }
    }

    public boolean checkSlotAvailability(Slot slot) {
        // Basic availability check
        return slot.getWaitList() == null;
    }

    public boolean processUPIPayment() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter UPI ID:");
        String upiId = scanner.nextLine();
        // Simulate payment processing
        return true;
    }

    public boolean processCardPayment(String cardType) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + cardType + " Card Number:");
        String cardNumber = scanner.nextLine();
        // Simulate payment processing
        return true;
    }

    public void bookSlot(Customer customer, Slot slot) {
        System.out.println("Slot booked for customer: " + customer.getCustomerName());
    }

    public void processRefund(Customer customer, Slot slot) {
        System.out.println("Processing refund for customer: " + customer.getCustomerName());
        System.out.println("Refund processed successfully");
    }
    
    PaymentDaoInterface paymentDao = new PaymentDAO();
	public void makePayment(Long cardNumber,String customerEmail) {
		paymentDao.makePayment(cardNumber, customerEmail);
		System.out.println("Payment Successful .....");
	}
}

