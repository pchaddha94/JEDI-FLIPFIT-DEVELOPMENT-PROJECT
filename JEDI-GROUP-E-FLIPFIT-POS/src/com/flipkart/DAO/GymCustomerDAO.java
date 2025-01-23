package com.flipkart.DAO;

import com.flipkart.bean.Customer;
import com.flipkart.client.FlipFitApplication;
import com.flipkart.utils.DB_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
