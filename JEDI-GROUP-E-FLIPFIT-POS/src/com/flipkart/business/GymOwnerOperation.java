package com.flipkart.business;

import com.flipkart.bean.BookSlot;
import com.flipkart.bean.Slot;

import java.util.List;

public class GymOwnerOperation {
    public Boolean AddCentre(Long centreID){
        return true;

    }
    public Boolean AddSlot(Slot slot, Long centreID){
        return true;
    }

    public Boolean RemoveCentre(Long centreID){
        return true;
    }

    public Boolean RemoveSlot(Slot slot, Long centreID){
        return true;
    }

    public List<BookSlot> ViewBookings(Long centreID){

        return null;
    }





}
