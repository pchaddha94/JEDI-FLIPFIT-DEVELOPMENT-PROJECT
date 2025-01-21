package com.flipkart.business;

import com.flipkart.bean.Feedback;
import java.util.List;

public class FeedbackOperation {

    public void addFeedback(Long userId, String comments, int rating) {
        System.out.println("Adding feedback for User ID: " + userId);
    }

    public void viewAllFeedback() {
        System.out.println("Fetching all feedback...");
    }

    public List<Feedback> getFeedbackByUserId(Long userId) {
        System.out.println("Fetching feedback for User ID: " + userId);
        return null;
    }

    public double getAverageRating() {
        System.out.println("Calculating average rating...");
        return 0.0;
    }

    public boolean deleteFeedback(Long feedbackId) {
        System.out.println("Deleting feedback with Feedback ID: " + feedbackId);
        return false;
    }
}