package com.flipkart.DAO;

import com.flipkart.bean.GymCenter;
import com.flipkart.constants.Constants;
import com.flipkart.utils.DB_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GymCenterDAO implements GymCenterDAOInterface{
    @Override
    public void addGymCenter(GymCenter gymCenter) {
        try{
            Connection connection = DB_utils.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Constants.INSERT_GYM);
            stmt.setString(1,gymCenter.getName());
            stmt.setString(2,gymCenter.getEmail());
            stmt.setBoolean(3,gymCenter.isIs_approved());
            stmt.setString(4,gymCenter.getLocation());
            stmt.setLong(5, gymCenter.getGymOwnerId());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Gym center added successfully");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Gym center failed");
    }

    @Override
    public List<GymCenter> getAllGymCenters() {
        try{
            Connection connection = DB_utils.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Constants.FETCH_ALL_GYM_CENTERS);
            ResultSet rs = stmt.executeQuery();
            List<GymCenter> gymCenters = new ArrayList<>();
            while(rs.next()){
                GymCenter gymCenter = new GymCenter();
                gymCenter.setId(rs.getLong(1));
                gymCenter.setName(rs.getString(2));
                gymCenter.setEmail(rs.getString(3));
                gymCenter.setIs_approved(rs.getBoolean(4));
                gymCenter.setLocation(rs.getString(5));
                gymCenter.setGymOwnerId(rs.getLong(6));
                gymCenters.add(gymCenter);
            }
            System.out.println("Gym center list retrieved successfully");
            return gymCenters;

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Fetching gym center failed.");
        return List.of();
    }
}
