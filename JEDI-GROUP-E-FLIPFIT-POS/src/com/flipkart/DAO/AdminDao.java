package com.flipkart.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.GymAdmin;
import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.UserRole;
import com.flipkart.constants.Constants;
import com.flipkart.utils.DB_utils;
import com.flipkart.utils.UserRoleType;

public class AdminDao implements AdminDaoInterface {

	Connection connection = null;
    PreparedStatement statement = null;

    private UserDaoInterface userDao = new UserDao();

    public List<GymCenter> viewPendingGymRequests(){
        List<GymCenter> pendingReq = new ArrayList<>();
        try {
            connection = DB_utils.getConnection();
            System.out.println("Getting Pending Requests...");
            statement = connection.prepareStatement(Constants.FETCH_PENDING_GYM_CENTERS);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                GymCenter gymCenter = new GymCenter();
                gymCenter.setId(rs.getLong("center_id"));
                gymCenter.setName(rs.getString("center_name"));
                gymCenter.setEmail(rs.getString("center_email_id"));
                gymCenter.setLocation(rs.getString("center_location"));
                gymCenter.setIs_approved(false);
                gymCenter.setGymOwnerId(rs.getLong("owner_id"));
                pendingReq.add(gymCenter);
            }
        } catch (Exception excep){
            System.out.println(excep.getMessage());
        }
        return pendingReq;
    }

    public List<GymOwner> viewPendingGymOwnerRequests(){
        List<GymOwner> pendingGymOwnerReq = new ArrayList<>();
        try {
            connection = DB_utils.getConnection();
            statement = connection.prepareStatement(Constants.FETCH_PENDING_GYM_OWNERS);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                GymOwner gymOwner = new GymOwner();
                gymOwner.setOwnerId(rs.getLong("owner_id"));
                gymOwner.setOwnerAddress(rs.getString("owner_address"));
                gymOwner.setApproved(false);
                gymOwner.setOwnerPhone(rs.getString("owner_phone_no"));
                gymOwner.setOwnerPanNum(rs.getString("owner_pan"));
                gymOwner.setOwnerName(rs.getString("owner_name"));
                gymOwner.setOwnerEmailAddress(rs.getString("owner_email_id"));              

                pendingGymOwnerReq.add(gymOwner);
            }
        } catch(Exception excep) {
            System.out.println(excep.getMessage());
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
            	gymCenter.setId(rs.getLong("center_id"));
                gymCenter.setName(rs.getString("center_name"));
                gymCenter.setEmail(rs.getString("center_email_id"));
                gymCenter.setLocation(rs.getString("center_location"));
                gymCenter.setIs_approved(true);
                gymCenter.setGymOwnerId(rs.getLong("owner_id"));
                approvedReq.add(gymCenter);
            }
        } catch (Exception excep){
            System.out.println(excep.getMessage());
        }
        return approvedReq;
    }

    public List<GymOwner> viewAllApprovedGymOnwers(){
        List<GymOwner> approvedGymOwnerReq = new ArrayList<>();
        try {
            connection = DB_utils.getConnection();
            System.out.println("Getting Approved Gym Owner Requests...");
            statement = connection.prepareStatement(Constants.FETCH_PENDING_OR_APPROVED_GYM_OWNERS);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
            	GymOwner gymOwner = new GymOwner();
                gymOwner.setOwnerId(rs.getLong("owner_id"));
                gymOwner.setOwnerAddress(rs.getString("owner_address"));
                gymOwner.setApproved(true);
                gymOwner.setOwnerPhone(rs.getString("owner_phone_no"));
                gymOwner.setOwnerPanNum(rs.getString("owner_pan"));
                gymOwner.setOwnerName(rs.getString("owner_name"));
                gymOwner.setOwnerEmailAddress(rs.getString("owner_email_id"));              


                approvedGymOwnerReq.add(gymOwner);
            }
        } catch(Exception excep) {
            System.out.println(excep.getMessage());
        }
        return approvedGymOwnerReq;
    }

    public boolean approveGymOwnerRegistration(long gymOwnerId) {
        int result = 0;
        try {
            connection = DB_utils.getConnection();
            System.out.println("Approving Gym Owner Requests...");
            statement = connection.prepareStatement(Constants.APPROVE_GYM_OWNER);
            statement.setLong(1, gymOwnerId);
            result = statement.executeUpdate();
            statement.close();
        } catch (Exception excep) {
            System.out.println(excep.getMessage());
        }
        if(result == 1){
            return true;
        }
        return false;
    }

    public boolean approveGymRegistration(long gymCenterId){
        int result = 0;
        try{
            connection = DB_utils.getConnection();
            System.out.println("Approving Gym Center Requests...");
            statement = connection.prepareStatement(Constants.APPROVE_GYM_CENTER);
            statement.setLong(1,gymCenterId);
            result = statement.executeUpdate();
            statement.close();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
        if(result == 1){
            return true;
        }
        return false;
    }

    public void addAdmin(GymAdmin gymAdmin){
        try{
            connection = DB_utils.getConnection();
            statement = connection.prepareStatement(Constants.ADD_ADMIN);
            statement.setString(1,gymAdmin.getAdminName());
            statement.setString(2,gymAdmin.getAdminEmailAddress());
            statement.setString(3,gymAdmin.getPhone());
            statement.setString(4,gymAdmin.getPassword());
            statement.executeUpdate();
            statement.close();

            UserRole userRole = new UserRole();
            userRole.setUserId(getAdminByEmail(gymAdmin.getAdminEmailAddress()).getAdminId());
            userRole.setUserRole(UserRoleType.ADMIN);
            userRole.setUserEmail(gymAdmin.getAdminEmailAddress());

            userDao.addUserRole(userRole);
            System.out.println("Added Admin Successfully");
            return;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Add Admin Failed");
    }

    @Override
    public GymAdmin getAdminByEmail(String email) {
        try{
            statement = connection.prepareStatement(Constants.GET_ADMIN_BY_EMAIL);
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if(resultSet.next()){
                GymAdmin gymAdmin=new GymAdmin();
                gymAdmin.setAdminId(resultSet.getLong("admin_id"));
                gymAdmin.setAdminName(resultSet.getString("admin_name"));
                gymAdmin.setAdminEmailAddress(resultSet.getString("admin_email_id"));
                gymAdmin.setPhone(resultSet.getString("admin_phone_no"));
                gymAdmin.setPassword(resultSet.getString("admin_password"));
                return gymAdmin;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Get Admin By Email failed");
        return null;
    }


}
