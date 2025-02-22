package com.flipkart.bean;

public class GymCenter {
	private Long id;
	private String name;
	private String email;
	private boolean is_approved;
	private  String  location;
	private Long gymOwnerId;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the is_approved
	 */
	public boolean isIs_approved() {
		return is_approved;
	}
	/**
	 * @param is_approved the is_approved to set
	 */
	public void setIs_approved(boolean is_approved) {
		this.is_approved = is_approved;
	}
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	public Long getGymOwnerId() {
		return gymOwnerId;
	}

	public void setGymOwnerId(Long gymOwnerId) {
		this.gymOwnerId = gymOwnerId;
	}
}
