package com.flipkart.bean;

public class Notification {
	
	public Long notificationID;
	public Long senderID;
	public Long receiverID;
	public String message;
	
	
	public Long getNotificationID() {
		return notificationID;
	}
	public void setNotificationID(Long notificationID) {
		this.notificationID = notificationID;
	}
	public Long getSenderID() {
		return senderID;
	}
	public void setSenderID(Long senderID) {
		this.senderID = senderID;
	}
	public Long getReceiverID() {
		return receiverID;
	}
	public void setReceiverID(Long receiverID) {
		this.receiverID = receiverID;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

	

}
