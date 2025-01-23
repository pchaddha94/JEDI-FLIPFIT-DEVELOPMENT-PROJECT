package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.flipkart.bean.UserRole;
import com.flipkart.utils.DB_utils;

public class UserDao implements UserDaoInterface{
	
	public UserRole getUser(String userEmail)
	{
		try{
            Connection connection = DB_utils.getConnection();
            String query = "SELECT user_id, user_role FROM jedi_flipfit_mysql.user_role WHERE user_email = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, userEmail);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                int userId = rs.getInt("user_id");
                String userRole = rs.getString("user_role");
                UserRole user = new UserRole();
                user.setId(rs.getLong("user_id"));
                user.setUserId(rs.getLong("user_id"));
                String role = rs.getString("user_role");
                user.setUserRole(role);
                return user;
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
		return null;
	}

}
