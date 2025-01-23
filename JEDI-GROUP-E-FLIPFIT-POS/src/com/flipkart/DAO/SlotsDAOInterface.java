package com.flipkart.DAO;

import com.flipkart.bean.Slot;

import java.util.List;

public interface SlotsDAOInterface {

    public List<Slot> getAllSlotsByGymCenterId(Long gymCenterId);

    public void addSlot(Slot slot);
}
