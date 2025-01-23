package com.flipkart.constants;

public class Constants {
	
	public static final String FETCH_ALL_APPROVED_GYMS = "SELECT * FROM GymCenter WHERE isApproved=1";
	public static final String FETCH_ALL_SLOTS_OF_GYM = "SELECT * FROM AllSlots WHERE gymCenterId=?";
	public static final String FETCH_GYMOWNER_DETAILS = "SELECT * FROM GymOwner WHERE email=?";
	public static final String FETCH_GYMOWNER_ALL_GYMS = "SELECT * FROM GymCenter WHERE gymOwnerEmail=?";
	public static final String INSERT_GYM = "INSERT INTO GymCenter (gymOwnerEmail, name, location, noOfSeats, isApproved) values (?, ?, ?, ?, ?)";

	public static final String CREATE_SLOT = "INSERT INTO Slot (id, time) values(?, ?)";
	public static final String INSERT_SLOT = "INSERT INTO AllSlots (gymCenterId, slotId, time) values(?, ?, ?)";

	public static final String INSERT_BOOKEDSLOT = "INSERT INTO BookedSlot (gymCenterId, slotId, customerEmail, date, isActive) values(?, ?, ?, ?, ?)";
	public static final String FETCH_GYMOWNER_ALL_APPROVED_GYMS = "SELECT * FROM GymCenter WHERE gymOwnerEmail=? and isApproved=1";
	public static final String CHECK_GYMOWNER_APPROVEVAL = "SELECT * FROM GymOwner WHERE email=? and isApproved=1";
	public static final String CHECK_GYMCENTER_APPROVEVAL = "SELECT * FROM GymCenter WHERE id=? and isApproved=1";
	public static final String FETCH_ALL_BOOKEDSLOTS = "SELECT * FROM BookedSlot WHERE customerEmail=? and isActive=?";
	public static final String CHECK_SLOT_ALREADY_BOOKED = "SELECT * FROM BookedSlot WHERE slotId=? and customerEmail=? and date=?";
	public static final String CANCEL_BOOKING = "UPDATE BookedSlot SET isActive = ? where id = ? and customerEmail = ?";
	public static final String FETCH_PENDING_GYM_CENTERS = "SELECT * FROM GymCenter WHERE isApproved = 0";
	public static final String FETCH_PENDING_OR_APPROVED_GYM_OWNERS = "SELECT * FROM GymOwner WHERE isApproved = ?";
	public static final String APPROVE_GYM_OWNER = "UPDATE GymOwner SET isApproved = true WHERE id = ?";
	public static final String APPROVE_GYM_CENTER = "UPDATE GymCenter SET isApproved = 1 WHERE id = ?";
	public static final String REGISTERING_NEW_CUSTOMER = "INSERT INTO jedi_flipfit_mysql.Customer (customer_name,customer_address,customer_email_id,customer_phone_no,customer_password) VALUES ( ?, ?, ?, ?, ?);";
	public static final String REGISTERING_NEW_GYMOWNER = "INSERT INTO GymOwner (name,address,email,phone,gstNumber,isApproved) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String REGISTERING_NEW_USER = "INSERT INTO User (email,password,roleId) VALUES (?, ?, ?)";
	public static final String FETCH_ALL_CUSTOMERS_USERS = "SELECT * FROM User WHERE roleId = ?";
	public static final String MAKE_PAYMENT = "INSERT INTO Payment (cardNumber, customerEmail) values(?, ?)";
	public static final String AUTHENTICATE_USER = "SELECT * FROM User Where email=? and password = ? and roleId=?";
	public static final String FETCH_CUSTOMER_BY_EMAIL = "SELECT * from jedi_flipfit_mysql.Customer where customer_email_id=?";
	public static final String FETCH_BOOKINGS_BY_CUSTOMER_ID = "SELECT * from jedi_flipfit_mysql.book_slot where customer_id=?;";
	public static final String ADD_SLOT_BOOKING = "INSERT INTO jedi_flipfit_mysql.bookslot(customer_id,slot_id,booking_date,booking_status) VALUES(?,?,?,?)";
}
