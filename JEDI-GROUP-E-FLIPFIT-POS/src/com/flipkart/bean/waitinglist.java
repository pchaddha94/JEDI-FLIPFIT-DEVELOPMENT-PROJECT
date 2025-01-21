package com.flipkart.bean;
import java.util.LinkedList;
import java.util.Queue;
public class WaitingList {
	private long centreId;
	private long waitListId;
	private int slotId;
	private Queue<Integer> waiting = new LinkedList<>();
	public long getCentreId() {
		return centreId;
	}
	public void setCentreId(long centreId) {
		this.centreId = centreId;
	}
	public long getWaitListId() {
		return waitListId;
	}
	public void setWaitListId(long waitListId) {
		this.waitListId = waitListId;
	}
	public int getSlotId() {
		return slotId;
	}
	public void setSlotId(int slotId) {
		this.slotId = slotId;
	}
	public Queue<Integer> getWaiting() {
		return waiting;
	}
	public void setWaiting(Queue<Integer> waiting) {
		this.waiting = waiting;
	}
	
}
