package com.flipkart.bean;

import com.flipkart.utils.UserRole;

public class GymOwner {

    private long ownerId;
    private String ownerName;
    private String ownerEmailAddress;
    private String ownerPhone;
    private String ownerPanNum;
    private boolean isApproved;
    private String ownerAddress;
    private final UserRole userRole = UserRole.OWNER;
    /**
     * @return the ownerId
     */
    public long getOwnerId() {
        return ownerId;
    }
    /**
     * @param ownerId the ownerId to set
     */
    public void setOwnerId(long ownerId) {
        this.ownerId = ownerId;
    }
    /**
     * @return the ownerName
     */
    public String getOwnerName() {
        return ownerName;
    }
    /**
     * @param ownerName the ownerName to set
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    /**
     * @return the ownerEmailAddress
     */
    public String getOwnerEmailAddress() {
        return ownerEmailAddress;
    }
    /**
     * @param ownerEmailAddress the ownerEmailAddress to set
     */
    public void setOwnerEmailAddress(String ownerEmailAddress) {
        this.ownerEmailAddress = ownerEmailAddress;
    }
    /**
     * @return the ownerPhone
     */
    public String getOwnerPhone() {
        return ownerPhone;
    }
    /**
     * @param ownerPhone the ownerPhone to set
     */
    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }
    /**
     * @return the ownerGSTNum
     */
    public String getOwnerPanNum() {
        return ownerPanNum;
    }
    /**
     * @param ownerGSTNum the ownerGSTNum to set
     */
    public void setOwnerPanNum(String ownerPanNum) {
        this.ownerPanNum = ownerPanNum;
    }
    /**
     * @return the isApproved
     */
    public boolean isApproved() {
        return isApproved;
    }
    /**
     * @param isApproved the isApproved to set
     */
    public void setApproved(boolean isApproved) {
        this.isApproved = isApproved;
    }
    /**
     * @return the ownerAddress
     */
    public String getOwnerAddress() {
        return ownerAddress;
    }
    /**
     * @param ownerAddress the ownerAddress to set
     */
    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress = ownerAddress;
    }

}

