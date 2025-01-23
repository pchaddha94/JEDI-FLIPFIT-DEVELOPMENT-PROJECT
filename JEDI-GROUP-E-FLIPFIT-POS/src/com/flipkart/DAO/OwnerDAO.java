package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.flipkart.bean.GymCenter;
import com.flipkart.bean.GymOwner;
import com.flipkart.bean.Slot;
import com.flipkart.bean.UserRole;
import com.flipkart.constants.Constants;
import com.flipkart.utils.DB_utils;
import com.flipkart.utils.UserRoleType;

public class OwnerDAO implements OwnerDAOInterface {

    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private UserDao userDao = new UserDao();
    public void addOwner(GymOwner gymOwner) {
        try {
            conn = DB_utils.getConnection();
            stmt = conn.prepareStatement(Constants.ADD_GYM_OWNER);
            stmt.setString(1, gymOwner.getOwnerName());
            stmt.setLong(2, gymOwner.getOwnerId());
            stmt.setString(3, gymOwner.getOwnerPanNum());
            stmt.setString(4, gymOwner.getOwnerPhone());
            stmt.setString(5, gymOwner.getOwnerAddress());
            stmt.setBoolean(6, gymOwner.isApproved());
            stmt.setString(7, gymOwner.getOwnerEmailAddress());
            stmt.setString(8,gymOwner.getPassword());
            stmt.executeUpdate();
            UserRole userRole = new UserRole();
            userRole.setUserId(getGymOwnerByEmail(gymOwner.getOwnerEmailAddress()).getOwnerId());
            userRole.setUserEmail(gymOwner.getOwnerEmailAddress());
            userRole.setUserRole(UserRoleType.OWNER);
            userDao.addUserRole(userRole);
            System.out.println("Owner registered successfully");
            return;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Owner registration failed");
    }

    @Override
    public ArrayList<GymOwner> getAllOwners() {
        return null;
    }

    @Override
    public GymOwner getOwnerByID(Long gymOwnerID) {
        return null;
    }

    public ArrayList<GymOwner> getOwners() {
        ArrayList<GymOwner> gymOwners = new ArrayList<GymOwner>();
        String sql = "SELECT * FROM gym_owner";
        try{
            conn = DB_utils.getConnection();
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                GymOwner gymOwner = new GymOwner();
                gymOwner.setOwnerId(rs.getLong("owner_id"));
                gymOwner.setOwnerName(rs.getString("owner_name"));
                gymOwner.setOwnerPanNum(rs.getString("owner_pan"));
                gymOwner.setOwnerPanNum(rs.getString("owner_phone_no"));
                gymOwner.setOwnerAddress(rs.getString("owner_address"));
                gymOwner.setApproved(rs.getBoolean("is_approved"));
                gymOwner.setOwnerEmailAddress(rs.getString("owner_email_id"));
                gymOwners.add(gymOwner);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return gymOwners;
    }

    public GymOwner getOwner(Long ownerId) {
        GymOwner gymOwner = new GymOwner();
        String sql = "SELECT * FROM gym_owner WHERE owner_id = ?";
        try{
            conn = DB_utils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, ownerId);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                gymOwner.setOwnerId(rs.getLong("owner_id"));
                gymOwner.setOwnerName(rs.getString("owner_name"));
                gymOwner.setOwnerPanNum(rs.getString("owner_pan"));
                gymOwner.setOwnerPanNum(rs.getString("owner_phone_no"));
                gymOwner.setOwnerAddress(rs.getString("owner_address"));
                gymOwner.setApproved(rs.getBoolean("is_approved"));
                gymOwner.setOwnerEmailAddress(rs.getString("owner_email_id"));

            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return gymOwner;
    }

    @Override
    public void addCenter(GymCenter center) {
        String sql = "INSERT INTO jedi_flipfit_mysql.gym_center(owner_id,is_approved,center_name,center_location,center_email_id) VALUES (?,?,?,?,?)";
        try {
            conn = DB_utils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1,center.getGymOwnerId());
            stmt.setBoolean(2,false);
            stmt.setString(3,center.getName());
            stmt.setString(4, center.getLocation());
            stmt.setString(5, center.getEmail());
            stmt.executeUpdate();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<GymCenter> getAllCenters(Long ownerID) {
        String sql = "SELECT * FROM gym_center WHERE owner_id = ?";
        ArrayList<GymCenter> centers = new ArrayList<>();
        try {
            conn = DB_utils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1, ownerID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                GymCenter center = new GymCenter();
                center.setGymOwnerId(rs.getLong("owner_id"));
                center.setIs_approved(rs.getBoolean("is_approved"));
                center.setEmail(rs.getString("center_email_id"));
                center.setId(rs.getLong("center_id"));
                center.setLocation(rs.getString("center_location"));
                center.setName(rs.getString("center_name"));
                centers.add(center);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return centers;
    }

    @Override
    public ArrayList<GymCenter> getAllApprovedCenters(Long ownerID) {
        String sql = "SELECT * FROM gym_center WHERE is_approved = 1 AND owner_id = ?";
        ArrayList<GymCenter> centers = new ArrayList<>();
        try{
            conn = DB_utils.getConnection();
            stmt = conn.prepareStatement(sql);
            stmt.setLong(1,ownerID);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                GymCenter center = new GymCenter();
                center.setGymOwnerId(rs.getLong("owner_id"));
                center.setIs_approved(rs.getBoolean("is_approved"));
                center.setEmail(rs.getString("center_email_id"));
                center.setId(rs.getLong("center_id"));
                center.setLocation(rs.getString("center_location"));
                center.setName(rs.getString("center_name"));
                centers.add(center);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return centers;
    }

    @Override
    public void addSlot(Long ownerID, Slot slot) {

    }

    @Override
    public ArrayList<Slot> getAllSlots(Long ownerID, Long centerID) {
        return null;
    }

    @Override
    public GymOwner getGymOwnerByEmail(String email) {
        try{
            conn = DB_utils.getConnection();
            stmt = conn.prepareStatement(Constants.FETCH_GYM_OWNER_BY_EMAIL_ID);
            stmt.setString(1,email);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                GymOwner gymOwner = new GymOwner();
                gymOwner.setOwnerId(rs.getLong("owner_id"));
                gymOwner.setOwnerName(rs.getString("owner_name"));
                gymOwner.setOwnerPanNum(rs.getString("owner_pan"));
                gymOwner.setOwnerPanNum(rs.getString("owner_phone_no"));
                gymOwner.setOwnerAddress(rs.getString("owner_address"));
                gymOwner.setApproved(rs.getBoolean("is_approved"));
                gymOwner.setOwnerEmailAddress(rs.getString("owner_email_id"));
                gymOwner.setPassword(rs.getString("password"));
                return gymOwner;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Invalid Email");
        return null;
    }
}
