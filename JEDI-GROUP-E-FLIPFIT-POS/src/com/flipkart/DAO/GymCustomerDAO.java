package com.flipkart.DAO;

import com.flipkart.bean.Customer;
import com.flipkart.client.FlipFitApplication;
import com.flipkart.utils.DB_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GymCustomerDAO implements GymCustomerDAOInterface{

    public void addCustomer(Customer customer){
        try{
            Connection connection = DB_utils.getConnection();
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO jedi_flipfit_mysql.Customer (customer_name,customer_address,customer_email_id,customer_phone_no,customer_password) VALUES ( ?, ?, ?, ?, ?);");
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
            PreparedStatement stmt = connection.prepareStatement("SELECT * from jedi_flipfit_mysql.Customer where customer_email_id=?");
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            Customer customer = new Customer();
            customer.setCustomerEmailAddress(rs.getString("customer_email_id"));
            customer.setPassword(rs.getString("customer_password"));
            customer.setCustomerName(rs.getString("customer_name"));
            customer.setCustomerPhone(rs.getString("phone"));
            return customer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
