package com.flipkart.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Objects;
import java.util.Properties;

public class DB_utils {
    private static Connection connection = null;

    public static Connection getConnection(){
        try {
            if (Objects.isNull(connection)) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                FileInputStream inputStream = new FileInputStream("/Users/manan.patel/Documents/Jedi-Project/JEDI-Flipfit-Repo/JEDI-GROUP-E-FLIPFIT-POS/src/com/flipkart/config.properties");
                Properties newProp = new Properties();
                newProp.load(inputStream);
                connection = DriverManager.getConnection(newProp.getProperty("db_url"), newProp.getProperty("db_user"),newProp.getProperty("db_password"));
                return connection;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
