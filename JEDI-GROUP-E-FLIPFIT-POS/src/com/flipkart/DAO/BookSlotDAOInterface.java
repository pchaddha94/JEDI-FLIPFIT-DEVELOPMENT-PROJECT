package com.flipkart.DAO;

import com.flipkart.bean.BookSlot;

import java.util.List;

public interface BookSlotDAOInterface {

    public List<BookSlot> getCustomerBookings(Long customerId);

    public void addCustomerBooking(BookSlot bookSlot);
}
