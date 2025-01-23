package com.flipkart.DAO;

import com.flipkart.bean.BookSlot;
import com.flipkart.constants.Constants;
import com.flipkart.utils.BookingStatusType;
import com.flipkart.utils.DB_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookSlotDAO implements BookSlotDAOInterface{

    @Override
    public List<BookSlot> getCustomerBookings(Long id){
        try{
            Connection connection = DB_utils.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Constants.FETCH_BOOKINGS_BY_CUSTOMER_ID);
            stmt.setString(1, id.toString());
            ResultSet resultSet = stmt.executeQuery();
            List<BookSlot> bookSlots = new ArrayList<BookSlot>();
            while (resultSet.next()) {
                BookSlot bookSlot = new BookSlot();
                bookSlot.setBookingId(resultSet.getLong("booking_id"));
                bookSlot.setCustomerId(resultSet.getLong("customer_id"));
                bookSlot.setSlotId(resultSet.getLong("slot_id"));
                bookSlot.setBookingDate(resultSet.getDate("booking_date"));
                bookSlot.setBookingStatus(BookingStatusType.valueOf(resultSet.getString("booking_status").toUpperCase()));
                bookSlots.add(bookSlot);
            }
            return bookSlots;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void addCustomerBooking(BookSlot bookSlot) {
        try{
            Connection connection = DB_utils.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Constants.ADD_SLOT_BOOKING);
            stmt.setLong(1, bookSlot.getCustomerId());
            stmt.setLong(2,bookSlot.getSlotId());
            stmt.setDate(3,bookSlot.getSlotBookingDate());
            stmt.setString(4,bookSlot.getBookingStatus().toString());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Booking slot added successfully");
            return;
            } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Booking slot failed");
    }
}
