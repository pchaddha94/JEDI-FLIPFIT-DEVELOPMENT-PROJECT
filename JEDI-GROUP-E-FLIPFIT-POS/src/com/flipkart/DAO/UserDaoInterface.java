package com.flipkart.DAO;

import com.flipkart.bean.UserRole;

public interface UserDaoInterface {

	UserRole getUser(String userEmail);

}
