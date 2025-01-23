package com.flipkart.DAO;

import com.flipkart.bean.Notification;
import com.flipkart.utils.DB_utils;
import com.flipkart.utils.DB_utils.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NotificationDao implements NotificationDaoInterface {
    
  

    @Override
    public boolean createNotification(Notification notification) {
        String query = "INSERT INTO notification (senderID, receiverID, message) VALUES (?, ?, ?)";
        try (Connection connection = DB_utils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, notification.getSenderID());
            preparedStatement.setLong(2, notification.getReceiverID());
            preparedStatement.setString(3, notification.getMessage());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    

    @Override
    public Notification getNotificationById(Long notificationID) {
        String query = "SELECT * FROM notification WHERE notificationID = ?";
        try (Connection connection = DB_utils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, notificationID);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return mapRowToNotification(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Notification> getAllNotifications() {
        String query = "SELECT * FROM notification";
        List<Notification> notifications = new ArrayList<>();
        try (Connection connection = DB_utils.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                notifications.add(mapRowToNotification(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return notifications;
    }

   

    @Override
    public boolean deleteNotification(Long notificationID) {
        String query = "DELETE FROM notification WHERE notificationID = ?";
        try (Connection connection = DB_utils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, notificationID);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Notification mapRowToNotification(ResultSet resultSet) throws SQLException {
        Notification notification = new Notification();
        notification.setNotificationID(resultSet.getLong("notificationID"));
        notification.setSenderID(resultSet.getLong("senderID"));
        notification.setReceiverID(resultSet.getLong("receiverID"));
        notification.setMessage(resultSet.getString("message"));
        return notification;
    }
}
