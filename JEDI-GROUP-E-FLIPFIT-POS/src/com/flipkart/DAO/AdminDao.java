package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.constants.Constants;
import com.flipkart.utils.DB_utils;

public class AdminDao implements AdminDaoInterface {

	Connection connection = null;
    PreparedStatement statement = null;

    public List<GymCenter> viewPendingGymRequests(){
        List<GymCenter> pendingReq = new ArrayList<>();
        try {
            connection = DB_utils.getConnection();
            System.out.println("Getting Pending Requests...");
            statement = connection.prepareStatement(Constants.FETCH_PENDING_GYM_CENTERS);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                GymCenter gymCenter = new GymCenter();
                gymCenter.setId(rs.getLong("id"));
                gymCenter.setName(rs.getString("name"));
                gymCenter.setEmail(rs.getString("email"));
                gymCenter.setLocation(rs.getString("location"));
                gymCenter.setIs_approved(false);
                gymCenter.setGymOwnerId(rs.getLong("gymOwnerId"));
                pendingReq.add(gymCenter);
            }
        } catch (SQLException sqlExcep){
            System.out.println(sqlExcep);
        } catch (Exception excep){
            excep.printStackTrace();
        }
        return pendingReq;
    }

    public List<GymOwner> viewPendingGymOwnerRequests(){
        List<GymOwner> pendingGymOwnerReq = new ArrayList<>();
        try {
            connection = DB_utils.getConnection();
            System.out.println("Getting Pending Gym Owner Requests...");
            statement = connection.prepareStatement(Constants.FETCH_PENDING_OR_APPROVED_GYM_OWNERS);
            statement.setString(1,"0");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                GymOwner gymOwner = new GymOwner();
                gymOwner.setOwnerId(rs.getLong("ownerId"));
                gymOwner.setOwnerAddress(rs.getString("ownerAddress"));
                gymOwner.setApproved(false);
                gymOwner.setOwnerPhone(rs.getString("OwnerPhone"));
                gymOwner.setOwnerPanNum(rs.getString("ownerPanNum"));
                gymOwner.setOwnerName(rs.getString("ownerName"));
                gymOwner.setOwnerEmailAddress(rs.getString("ownerEmailAddress"));              

                pendingGymOwnerReq.add(gymOwner);
            }
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }
        return pendingGymOwnerReq;
    }

    public List<GymCenter> viewAllApprovedGyms(){
        List<GymCenter> approvedReq = new ArrayList<>();
        try {
            connection = DB_utils.getConnection();
            System.out.println("Getting Approved Requests...");
            statement = connection.prepareStatement(Constants.FETCH_ALL_APPROVED_GYMS);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
            	GymCenter gymCenter = new GymCenter();
                gymCenter.setId(rs.getLong("id"));
                gymCenter.setName(rs.getString("name"));
                gymCenter.setEmail(rs.getString("email"));
                gymCenter.setLocation(rs.getString("location"));
                gymCenter.setIs_approved(false);
                gymCenter.setGymOwnerId(rs.getLong("gymOwnerId"));
                approvedReq.add(gymCenter);
            }
        } catch (SQLException sqlExcep){
            System.out.println(sqlExcep);
        } catch (Exception excep){
            excep.printStackTrace();
        }
        return approvedReq;
    }

    public List<GymOwner> viewAllApprovedGymOnwers(){
        List<GymOwner> approvedGymOwnerReq = new ArrayList<>();
        try {
            connection = DB_utils.getConnection();
            System.out.println("Getting Approved Gym Owner Requests...");
            statement = connection.prepareStatement(Constants.FETCH_PENDING_OR_APPROVED_GYM_OWNERS);
            statement.setString(1,"1");
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
            	GymOwner gymOwner=new GymOwner();
            	gymOwner.setOwnerId(rs.getLong("ownerId"));
                gymOwner.setOwnerAddress(rs.getString("ownerAddress"));
                gymOwner.setApproved(false);
                gymOwner.setOwnerPhone(rs.getString("OwnerPhone"));
                gymOwner.setOwnerPanNum(rs.getString("ownerPanNum"));
                gymOwner.setOwnerName(rs.getString("ownerName"));
                gymOwner.setOwnerEmailAddress(rs.getString("ownerEmailAddress"));

                approvedGymOwnerReq.add(gymOwner);
            }
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }
        return approvedGymOwnerReq;
    }

    public boolean approveGymOwnerRegistration(int gymOwnerId) {
        int result = 0;
        try {
            connection = DB_utils.getConnection();
            System.out.println("Approving Gym Owner Requests...");
            statement = connection.prepareStatement(Constants.APPROVE_GYM_OWNER);
            statement.setInt(1, gymOwnerId);
            result = statement.executeUpdate();
            statement.close();
        } catch (SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch (Exception excep) {
            excep.printStackTrace();
        }
        if(result == 1){
            return true;
        }
        return false;
    }

    public boolean approveGymRegistration(int gymCenterId){
        int result = 0;
        try{
            connection = DB_utils.getConnection();
            System.out.println("Approving Gym Center Requests...");
            statement = connection.prepareStatement(Constants.APPROVE_GYM_CENTER);
            statement.setInt(1,gymCenterId);
            result = statement.executeUpdate();
            statement.close();
        } catch(SQLException sqlExcep) {
            System.out.println(sqlExcep);
        } catch(Exception excep) {
            excep.printStackTrace();
        }
        if(result == 1){
            return true;
        }
        return false;
    }
}
