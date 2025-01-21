package com.flipkart.bean;

public class Feedback {

    private Long feedbackId;
    private Long userId;
    private String comments;
    private int rating; 
    private Long centreId;
    
	public Long getCentreId() {
		return centreId;
	}

	public void setCentreId(Long centreId) {
		this.centreId = centreId;
	}

	public Long getFeedbackId() {
		return feedbackId;
	}
	
	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	

    

}
