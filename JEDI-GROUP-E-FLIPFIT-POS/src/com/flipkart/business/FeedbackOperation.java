/**
 * CustomerOperations class handles various customer-related functionalities
 * such as creating customers, booking slots, searching gyms, and updating profiles.
 */

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
	// DAO instances to interact with the database
	private final FeedbackDAOInterface feedbackDAO = new FeedbackDAO();
    /**
     * Adds feedback for a specific gym center by a user.
     * 
     * @param userId    ID of the user providing feedback
     * @param comments  User's feedback comments
     * @param rating    Rating given by the user (out of 5)
     * @param centreId  ID of the gym center the feedback is for
     */
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
    /**
     * Retrieves and displays all feedback available in the system.
     */
    public void viewAllFeedback() {
        System.out.println("Fetching all feedback...");
        
        // Retrieving the list of feedback from the database
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

    /**
     * Retrieves a list of feedback submitted by a specific user.
     * 
     * @param userId ID of the user whose feedback is to be fetched
     * @return List of Feedback objects submitted by the user
     */
    public List<Feedback> getFeedbackByUserId(Long userId) {
        System.out.println("Fetching feedback for User ID: " + userId);
        return feedbackDAO.getFeedbackByUserId(userId);
    }

    /**
     * Calculates and returns the average rating of all feedback received.
     * 
     * @return Average rating as a double value
     */
    public double getAverageRating() {
        System.out.println("Calculating average rating...");
        return feedbackDAO.getAverageRating();
    }

    /**
     * Deletes feedback based on the given feedback ID.
     * 
     * @param feedbackId ID of the feedback to be deleted
     * @return true if the deletion was successful, false otherwise
     */
    public boolean deleteFeedback(Long feedbackId) {
        System.out.println("Deleting feedback with Feedback ID: " + feedbackId);
        return feedbackDAO.deleteFeedback(feedbackId);
    }
}