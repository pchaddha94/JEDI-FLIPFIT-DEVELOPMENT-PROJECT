package com.flipkart.business;

import com.flipkart.bean.Slot;

public class SlotOperation {

    public Slot getSlot(Long slotId) {
        System.out.println("Getting slot with Slot Id: " + slotId);
        return new Slot();
    }

    public Slot addSlot(Slot slot) {
        System.out.println("Adding slot: " + slot);
        return slot;
    }

    public Slot removeSlot(Long slotId) {
        System.out.println("Removing slot with Slot Id: " + slotId);
        return new Slot();
    }

    public boolean bookSlot(Long slotId) {
        System.out.println("Booking slot with Slot Id: " + slotId);
        return true;
    }
}
