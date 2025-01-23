package com.flipkart.business;

import com.flipkart.bean.Feedback;
import java.util.List;

import com.flipkart.DAO.FeedbackDAO;
import com.flipkart.DAO.FeedbackDAOInterface;

public class FeedbackOperation {

//    public void addFeedback(Long userId, String comments, int rating) {
//        System.out.println("Adding feedback for User ID: " + userId);
//    }
//
//    public void viewAllFeedback() {
//        System.out.println("Fetching all feedback...");
//    }
	private final FeedbackDAOInterface feedbackDAO = new FeedbackDAO();

    public void addFeedback(Long userId, String comments, int rating, Long centreId) {
        System.out.println("Adding feedback for User ID: " + userId);
        Feedback feedback = new Feedback();
        feedback.setUserId(userId);
        feedback.setComments(comments);
        feedback.setRating(rating);
        feedback.setCentreId(centreId);

        boolean isAdded = feedbackDAO.addFeedback(feedback);
        if (isAdded) {
            System.out.println("Feedback added successfully.");
        } else {
            System.out.println("Failed to add feedback.");
        }
    }

    public void viewAllFeedback() {
        System.out.println("Fetching all feedback...");
        List<Feedback> feedbackList = feedbackDAO.getAllFeedback();
        if (feedbackList.isEmpty()) {
            System.out.println("No feedback found.");
        } else {
            for (Feedback feedback : feedbackList) {
                System.out.println("Feedback ID: " + feedback.getFeedbackId() +
                        ", User ID: " + feedback.getUserId() +
                        ", Comments: " + feedback.getComments() +
                        ", Rating: " + feedback.getRating() +
                        ", Centre ID: " + feedback.getCentreId());
            }
        }
    }


    public List<Feedback> getFeedbackByUserId(Long userId) {
        System.out.println("Fetching feedback for User ID: " + userId);
        return feedbackDAO.getFeedbackByUserId(userId);
    }

    public double getAverageRating() {
        System.out.println("Calculating average rating...");
        return feedbackDAO.getAverageRating();
    }

    public boolean deleteFeedback(Long feedbackId) {
        System.out.println("Deleting feedback with Feedback ID: " + feedbackId);
        return feedbackDAO.deleteFeedback(feedbackId);
    }
}