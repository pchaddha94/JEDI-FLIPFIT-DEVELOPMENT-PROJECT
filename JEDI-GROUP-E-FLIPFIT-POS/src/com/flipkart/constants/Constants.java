package com.flipkart.constants;

public class Constants {
	

	public static final String FETCH_ALL_SLOTS_OF_GYM = "SELECT * FROM jedi_flipfit_mysql.slots WHERE center_id=?";
	public static final String FETCH_GYMOWNER_DETAILS = "SELECT * FROM GymOwner WHERE email=?";
	public static final String FETCH_GYMOWNER_ALL_GYMS = "SELECT * FROM GymCenter WHERE gymOwnerEmail=?";
	public static final String FETCH_GYM_OWNER_BY_EMAIL_ID = "SELECT * FROM jedi_flipfit_mysql.gym_owner WHERE owner_email_id=?";
	public static final String INSERT_GYM = "INSERT INTO jedi_flipfit_mysql.gym_center (center_name,center_email_id,is_approved,center_location,owner_id) values (?, ?, ?, ?, ?)";

	public static final String CREATE_SLOT = "INSERT INTO Slot (id, time) values(?, ?)";
	public static final String INSERT_SLOT = "INSERT INTO jedi_flipfit_mysql.slots (center_id, slot_timings, slot_price) values(?, ?, ?)";
	public static final String INSERT_BOOKEDSLOT = "INSERT INTO BookedSlot (gymCenterId, slotId, customerEmail, date, isActive) values(?, ?, ?, ?, ?)";
	public static final String FETCH_GYMOWNER_ALL_APPROVED_GYMS = "SELECT * FROM GymCenter WHERE gymOwnerEmail=? and isApproved=1";
	public static final String CHECK_GYMOWNER_APPROVEVAL = "SELECT * FROM GymOwner WHERE email=? and isApproved=1";
	public static final String CHECK_GYMCENTER_APPROVEVAL = "SELECT * FROM GymCenter WHERE id=? and isApproved=1";
	public static final String FETCH_ALL_BOOKEDSLOTS = "SELECT * FROM BookedSlot WHERE customerEmail=? and isActive=?";
	public static final String CHECK_SLOT_ALREADY_BOOKED = "SELECT * FROM BookedSlot WHERE slotId=? and customerEmail=? and date=?";
	public static final String CANCEL_BOOKING = "UPDATE BookedSlot SET isActive = ? where id = ? and customerEmail = ?";
	
	public static final String FETCH_PENDING_GYM_CENTERS = "SELECT * FROM gym_center WHERE is_approved = 0";
	
	public static final String FETCH_PENDING_GYM_OWNERS = "SELECT * FROM gym_owner WHERE is_approved = 0";
	
	public static final String FETCH_PENDING_OR_APPROVED_GYM_OWNERS= "SELECT * FROM gym_owner";
	
	public static final String FETCH_ALL_APPROVED_GYMS = "SELECT * FROM gym_center WHERE is_approved=1";
	
	public static final String APPROVE_GYM_OWNER = "UPDATE gym_owner SET is_approved = true WHERE owner_id = ?";
	
	public static final String APPROVE_GYM_CENTER = "UPDATE gym_center SET is_approved = 1 WHERE center_id = ?";
	public static final String REGISTERING_NEW_CUSTOMER = "INSERT INTO jedi_flipfit_mysql.Customer (customer_name,customer_address,customer_email_id,customer_phone_no,customer_password) VALUES ( ?, ?, ?, ?, ?);";
	public static final String REGISTERING_NEW_GYMOWNER = "INSERT INTO GymOwner (name,address,email,phone,gstNumber,isApproved) VALUES (?, ?, ?, ?, ?, ?)";
	public static final String REGISTERING_NEW_USER = "INSERT INTO User (email,password,roleId) VALUES (?, ?, ?)";
	public static final String FETCH_ALL_CUSTOMERS_USERS = "SELECT * FROM User WHERE roleId = ?";
	public static final String MAKE_PAYMENT = "INSERT INTO Payment (cardNumber, customerEmail) values(?, ?)";
	public static final String AUTHENTICATE_USER = "SELECT * FROM User Where email=? and password = ? and roleId=?";
	public static final String FETCH_CUSTOMER_BY_EMAIL = "SELECT * from jedi_flipfit_mysql.Customer where customer_email_id=?";
	public static final String FETCH_BOOKINGS_BY_CUSTOMER_ID = "SELECT * from jedi_flipfit_mysql.book_slot where customer_id=?;";
	public static final String ADD_SLOT_BOOKING = "INSERT INTO jedi_flipfit_mysql.book_slot(customer_id,slot_id,booking_date,booking_status) VALUES(?,?,?,?)";
	public static final String FETCH_ALL_GYM_CENTERS = "SELECT * from jedi_flipfit_mysql.gym_center WHERE is_approved=1";
	public static final String INSERT_USER_ROLE = "INSERT INTO jedi_flipfit_mysql.user_role (user_id,user_role,user_email) VALUES (?,?,?)";
	public static final String ADD_ADMIN = "INSERT INTO jedi_flipfit_mysql.gym_admin (admin_name, admin_email_id, admin_phone_no, admin_password) VALUES (?,?,?,?)";
	public static final String GET_ADMIN_BY_EMAIL = "SELECT * from jedi_flipfit_mysql.gym_admin where admin_email_id=?";
	public static final String ADD_GYM_OWNER = "INSERT INTO jedi_flipfit_mysql.gym_owner (owner_name, owner_id,owner_pan,owner_phone_no,owner_address,is_approved,owner_email_id,password) VALUES (?,?,?,?,?,?,?,?)";
}
