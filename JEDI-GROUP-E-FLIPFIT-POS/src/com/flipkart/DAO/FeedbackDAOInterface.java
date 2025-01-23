package com.flipkart.DAO;

import com.flipkart.bean.Feedback;
import java.util.List;

public interface FeedbackDAOInterface {
	
	 // Add new feedback
    boolean addFeedback(Feedback feedback);

    // Retrieve all feedback
    List<Feedback> getAllFeedback();

    // Retrieve feedback by user ID
    List<Feedback> getFeedbackByUserId(Long userId);

    // Get average rating for all feedback
    double getAverageRating();

    // Delete feedback by ID
    boolean deleteFeedback(Long feedbackId);

}
