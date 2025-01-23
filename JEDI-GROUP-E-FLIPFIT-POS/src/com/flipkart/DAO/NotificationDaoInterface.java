package com.flipkart.DAO;

import com.flipkart.bean.Notification;
import java.util.List;

public interface NotificationDaoInterface {
    
    // Create a new notification
    boolean createNotification(Notification notification);
    
    // Retrieve a notification by ID
    Notification getNotificationById(Long notificationID);
    
    // Retrieve all notifications
    List<Notification> getAllNotifications();
    
    // Update an existing notification
   
    
    // Delete a notification by ID
    boolean deleteNotification(Long notificationID);
}
