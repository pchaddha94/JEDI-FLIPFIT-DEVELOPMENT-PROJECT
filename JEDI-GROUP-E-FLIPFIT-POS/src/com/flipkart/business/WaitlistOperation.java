package com.flipkart.business;

import com.flipkart.bean.Customer;
import com.flipkart.bean.WaitingList;

import java.util.LinkedList;
import java.util.Queue;

public class WaitlistOperation {
	WaitingList waitingList = new WaitingList();

public void initializeWaitingList(long waitListId, long centreId, int slotId) {
	waitingList.setWaitListId(waitListId);
	waitingList.setCentreId(centreId);
	waitingList.setSlotId(slotId);
	waitingList.setWaiting(new LinkedList<>());
	System.out.println("initializeWaitingList() called: Waiting list initialized with ID: " + waitListId + ",Centre ID: " + centreId + ", Slot ID: " + slotId);
}

public boolean addCustomerToWaitlist(Customer customer) {
//add customer 
	System.out.println("addCustomerToWaitlist() called: Customer " + customer.getCustomerName() + " added to the waiting list.");
	return true;
}

public boolean serveNextCustomer(Customer customer) {

//find next customer
	System.out.println("serveNextCustomer() called: Customer " + customer.getCustomerName()+ " has been served.");
	return true;
}

public boolean viewWaitingList() {
//view list
	System.out.println("viewWaitingList() called: Current waiting list: " );
	return true;
}


public boolean isWaitingListEmpty() {
//check it is empty
	System.out.println("waitinglist is empty");
	return true;
}

}