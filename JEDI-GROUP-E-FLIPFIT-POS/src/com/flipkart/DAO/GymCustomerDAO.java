package com.flipkart.DAO;

import com.flipkart.bean.BookSlot;
import com.flipkart.bean.Customer;
import com.flipkart.client.FlipFitApplication;
import com.flipkart.constants.Constants;
import com.flipkart.utils.BookingStatusType;
import com.flipkart.utils.DB_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GymCustomerDAO implements GymCustomerDAOInterface{

    public void addCustomer(Customer customer){
        try{
            Connection connection = DB_utils.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Constants.REGISTERING_NEW_CUSTOMER);
            stmt.setString(1, customer.getCustomerName());
            stmt.setString(2, customer.getCustomerAddress());
            stmt.setString(3, customer.getCustomerEmailAddress());
            stmt.setString(4, customer.getCustomerPhone());
            stmt.setString(5, customer.getPassword());
            stmt.executeUpdate();
            stmt.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        try {
            Connection connection = DB_utils.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Constants.FETCH_CUSTOMER_BY_EMAIL);
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Customer customer = new Customer();
            customer.setCustomerEmailAddress(rs.getString("customer_email_id"));
            customer.setPassword(rs.getString("customer_password"));
            customer.setCustomerName(rs.getString("customer_name"));
            customer.setCustomerPhone(rs.getString("customer_phone_no"));
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
