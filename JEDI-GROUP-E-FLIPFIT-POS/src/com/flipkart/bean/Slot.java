/**
 * 
 */

/**
 * 
 */
public class Slot {
	
	private long slotID;
	private String slotTimings ; // 24 hr format: Eg : "16:00". Will be start timing
	private int price;
	//Waiting list to be added
	
	
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
	
	
	
	

}
