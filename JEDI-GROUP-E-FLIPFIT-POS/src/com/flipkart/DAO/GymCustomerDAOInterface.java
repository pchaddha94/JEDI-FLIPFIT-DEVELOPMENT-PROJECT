package com.flipkart.DAO;

import com.flipkart.bean.Customer;

public interface GymCustomerDAOInterface {

    public void addCustomer(Customer customer);

    public Customer getCustomerByEmail(String email);
}
