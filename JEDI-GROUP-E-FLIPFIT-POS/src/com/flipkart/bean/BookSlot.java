package com.flipkart.bean;

import com.flipkart.utils.BookingStatusType;

import java.sql.Date;


public class BookSlot {
    private Long bookingId;
    private Long customerId;
    private Long slotId;
    private Date slotBookingDate;

    public java.sql.Date getSlotBookingDate() {
        return slotBookingDate;
    }

    public void setSlotBookingDate(Date slotBookingDate) {
        this.slotBookingDate = slotBookingDate;
    }

    private Date bookingDate;
    private BookingStatusType bookingStatus;

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatusType getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatusType bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
