package com.flipkart.bean;

public class Slot {
	
	private Long slotID;
	private String slotTimings ; // 24 hr format: Eg : "16:00". Will be start timing
	private int price;
	private Long centreId;
	private WaitingList waitList;
	//Waiting list to be added
	
	
	public WaitingList getWaitList() {
		return waitList;
	}
	public void setWaitList(WaitingList waitList) {
		this.waitList = waitList;
	}
	public long getSlotID() {
		return slotID;
	}
	public void setSlotID(long slotID) {
		this.slotID = slotID;
	}
	public String getSlotTimings() {
		return slotTimings;
	}
	public void setSlotTimings(String slotTimings) {
		this.slotTimings = slotTimings;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Long getCentreId() {
		return centreId;
	}

	public void setCentreId(Long centreId) {
		this.centreId = centreId;
	}
}
