package com.flipkart.DAO;

import com.flipkart.bean.BookSlot;
import com.flipkart.bean.Customer;

import java.util.List;

public interface GymCustomerDAOInterface {

    public void addCustomer(Customer customer);

    public Customer getCustomerByEmail(String email);
}
