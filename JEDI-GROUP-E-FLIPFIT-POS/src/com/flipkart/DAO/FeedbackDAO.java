package com.flipkart.DAO;

import com.flipkart.bean.Feedback;
import com.flipkart.constants.Constants;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.flipkart.utils.DB_utils;
import com.flipkart.utils.DB_utils.*;

public class FeedbackDAO implements FeedbackDAOInterface {

    @Override
    public boolean addFeedback(Feedback feedback) {
        String query = "INSERT INTO feedback (user_id, comments, rating, center_id) VALUES (?, ?, ?, ?)";
        try {
            Connection connection = DB_utils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, feedback.getUserId());
            preparedStatement.setString(2, feedback.getComments());
            preparedStatement.setInt(3, feedback.getRating());
            preparedStatement.setLong(4, feedback.getCentreId());
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Feedback> getAllFeedback() {
        String query = "SELECT * FROM feedback";
        List<Feedback> feedbackList = new ArrayList<>();
        try{ Connection connection = DB_utils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(Constants.GET_FEEDBACK);
            while (resultSet.next()) {
                feedbackList.add(mapRowToFeedback(resultSet));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return feedbackList;
    }

    @Override
    public List<Feedback> getFeedbackByUserId(Long userId) {

        List<Feedback> feedbackList = new ArrayList<>();
        try {Connection connection = DB_utils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(Constants.GET_FEEDBACK_BY_USERID);
            preparedStatement.setLong(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    feedbackList.add(mapRowToFeedback(resultSet));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return feedbackList;
    }

    @Override
    public double getAverageRating() {
        String query = "SELECT AVG(rating) AS avgRating FROM feedback";
        try {Connection connection = DB_utils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getDouble("avgRating");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0.0;
    }

    @Override
    public boolean deleteFeedback(Long feedbackId) {
        String query = "DELETE FROM feedback WHERE feedback_id = ?";
        try {Connection connection = DB_utils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setLong(1, feedbackId);
            return preparedStatement.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<Feedback> getAllFeedbackOfGymCenter(Long gymCenterId) {
        List<Feedback> feedbackList = getAllFeedback();
        List<Feedback> gymCenterFeedbackList = new ArrayList<>();
        for (Feedback feedback : feedbackList) {
            if(Objects.equals(gymCenterId,feedback.getCentreId())){
                gymCenterFeedbackList.add(feedback);
            }
        }
        return gymCenterFeedbackList;
    }

    private Feedback mapRowToFeedback(ResultSet resultSet) throws SQLException {
        Feedback feedback = new Feedback();
        feedback.setFeedbackId(resultSet.getLong("feedback_id"));
        feedback.setUserId(resultSet.getLong("user_id"));
        feedback.setComments(resultSet.getString("comments"));
        feedback.setRating(resultSet.getInt("rating"));
        feedback.setCentreId(resultSet.getLong("center_id"));
        return feedback;
    }
}

