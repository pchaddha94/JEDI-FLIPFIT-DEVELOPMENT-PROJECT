package com.flipkart.DAO;

import com.flipkart.bean.Slot;
import com.flipkart.constants.Constants;
import com.flipkart.utils.DB_utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SlotsDAO implements SlotsDAOInterface {
    @Override
    public List<Slot> getAllSlotsByGymCenterId(Long gymCenterId) {
        try{
            Connection connection = DB_utils.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Constants.FETCH_ALL_SLOTS_OF_GYM);
            stmt.setLong(1, gymCenterId);
            ResultSet rs = stmt.executeQuery();
            List<Slot> slots = new ArrayList<>();
            while(rs.next()){
                Slot slot = new Slot();
                slot.setSlotID(rs.getLong("slot_id"));
                slot.setSlotTimings(rs.getString("slot_timings"));
                slot.setPrice(rs.getInt("slot_price"));
                slot.setCentreId(rs.getLong("center_id"));
                slot.setAvailableSeats(rs.getLong(("available_seats")));
                slots.add(slot);
            }
            return slots;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void addSlot(Slot slot) {
        try{
            Connection connection = DB_utils.getConnection();
            PreparedStatement stmt = connection.prepareStatement(Constants.INSERT_SLOT);
            stmt.setLong(1, slot.getCentreId());
            stmt.setString(2, slot.getSlotTimings());
            stmt.setInt(3, slot.getPrice());
            stmt.setLong(4, slot.getAvailableSeats());
            stmt.executeUpdate();
            stmt.close();
            System.out.println("Slot added successfully");
            return;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Slot added fail");
    }

    @Override
    public Boolean decreaseSeat(Long slotId) {
        try{
            Slot slot = getSlotById(slotId);
            if(Objects.isNull(slot)){
                System.out.println("Slot not found");
                return false;
            }
            if(slot.getAvailableSeats()==0){
                System.out.println("Slot has no available seats");
                return false;
            }
            Connection connection = DB_utils.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.DECREASE_SEAT);
            statement.setLong(1, slotId);
            statement.executeUpdate();
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public Slot getSlotById(Long slotId) {
        try{
            Connection connection = DB_utils.getConnection();
            PreparedStatement statement = connection.prepareStatement(Constants.GET_SLOT_BY_ID);
            statement.setLong(1, slotId);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                Slot slot = new Slot();
                slot.setSlotID(rs.getLong("slot_id"));
                slot.setSlotTimings(rs.getString("slot_timings"));
                slot.setPrice(rs.getInt("slot_price"));
                slot.setCentreId(rs.getLong("center_id"));
                slot.setAvailableSeats(rs.getLong(("available_seats")));
                return slot;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
