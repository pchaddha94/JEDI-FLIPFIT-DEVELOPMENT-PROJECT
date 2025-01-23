/**
 * 
 */
package com.flipkart.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 
 */
public class DBUtils {

    private static Connection connection = null;

    public static Connection getConnection() {

        if (connection != null)
            return connection;
        else {
            try {
                Properties prop = new Properties();
                FileInputStream fileInputStream = new FileInputStream("/Users/arava.krishnaveni/Documents/workspace-spring-tool-suite-4-4.20.1.RELEASE/Test/GMS_JEDI_Flipkart_Java_POS/src/config.properties");
                prop.load(fileInputStream);
//                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String password = prop.getProperty("password");
//                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);

            } catch (SQLException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }
}
