


package com.flipkart.DAO;
import com.flipkart.utils. DB_utils;
import com.flipkart.constants.Constants;

//import com.flipkart.bean.Customer;
//import com.flipkart.bean.Slot;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//According to Payment Operations 

/*
public class PaymentDaoInterface implements PaymentDAO {
 Connection connection = null;
 PreparedStatement statement = null;

 public void processPayment(Customer customer, Slot slot) {
     try {
         connection =  DB_utils.getConnection();
         statement = connection.prepareStatement(Constants.PROCESS_PAYMENT);
         statement.setString(1, customer.getCustomerEmailAddress());
         statement.setLong(2, slot.getSlotID());
         statement.executeUpdate();
         statement.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 public boolean checkSlotAvailability(Slot slot) {
     boolean available = false;
     try {
         connection = DB_utils.getConnection();
         statement = connection.prepareStatement(Constants.CHECK_SLOT_AVAILABILITY);
         statement.setLong(1, slot.getSlotID());
         ResultSet resultSet = statement.executeQuery();
         if (resultSet.next()) {
             available = resultSet.getBoolean("isAvailable");
         }
         statement.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
     return available;
 }

 public boolean processUPIPayment() {
     // Simulating UPI payment processing
     System.out.println("Processing UPI payment...");
     return true;
 }

 public boolean processCardPayment(String cardType) {
     // Simulating Card payment processing
     System.out.println("Processing card payment with card type: " + cardType);
     return true;
 }

 public void bookSlot(Customer customer, Slot slot) {
     try {
         connection =  DB_utils.getConnection();
         statement = connection.prepareStatement(Constants.BOOK_SLOT);
         statement.setLong(1, slot.getSlotID());
         statement.setString(2, customer.getCustomerEmailAddress());
         statement.executeUpdate();
         statement.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }

 public void processRefund(Customer customer, Slot slot) {
     try {
         connection =  DB_utils.getConnection();
         statement = connection.prepareStatement(Constants.PROCESS_REFUND);
         statement.setString(1, customer.getCustomerEmailAddress());
         statement.setLong(2, slot.getSlotID());
         statement.executeUpdate();
         statement.close();
     } catch (SQLException e) {
         e.printStackTrace();
     }
 }
}*/

//Taking Reference
public class PaymentDAO implements PaymentDaoInterface{
 Connection connection = null;
 PreparedStatement statement = null;
 public void makePayment(Long cardNumber,String customerEmail){

     try {
         connection = DB_utils.getConnection();
         statement = connection.prepareStatement(Constants.MAKE_PAYMENT);
         statement.setLong(1,cardNumber);
         statement.setString(2,customerEmail);
         statement.executeUpdate();
         statement.close();

     } catch(SQLException sqlExcep) {
         System.out.println(sqlExcep);
     } catch(Exception excep) {
         excep.printStackTrace();
     }
 }
 
/*Check running or not */
 /*
public static void main(String[] args) {
    PaymentDAO paymentDAO = new PaymentDAO();
    
    // Example data (Replace with real values)
    Long cardNumber = 1234567890123456L;
    String customerEmail = "customer@example.com";

    // Calling the method to make a payment
    paymentDAO.makePayment(cardNumber, customerEmail);

    System.out.println("Payment process completed.");
}*/
}



