package com.flipkart.DAO;

import com.flipkart.bean.GymCenter;

import java.util.List;

public interface GymCenterDAOInterface {

    public void addGymCenter(GymCenter gymCenter);

    public List<GymCenter> getAllGymCenters();
}
