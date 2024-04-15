package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import com.project.model.User;

public class UserDao {
    // This method is responsible for saving a user to the database
    public String save(User user) {
        // Create a new database connection
        try (Connection con = DatabaseConnectivity.getConnection()) {
            if (con != null) {
                try (PreparedStatement ps = con.prepareStatement("INSERT INTO user(UserName, Password, Email, PhoneNumber) VALUES (?, ?, ?, ?)")) {
                    ps.setString(1, user.getUserName());
                    ps.setString(2, user.getPassword());
                    ps.setString(3, user.getEmail());
                    ps.setString(4, user.getPhoneNumber());
                    int rowsAffected = ps.executeUpdate();
                    if (rowsAffected > 0) {
                        return "Success";
                    } else {
                        return "Failed";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed";
    }
    
    //Method to check the user validation
    public String loginDetails(String username, String password) {
        // Create a new database connection
        try (Connection con = DatabaseConnectivity.getConnection()) {
            if (con != null) {
                try (PreparedStatement ps = con.prepareStatement("Select * from user where username = ?")) {
                    ps.setString(1, username);
                    ResultSet rs = ps.executeQuery();
                    if(rs.next()) {
                    	if(password.equalsIgnoreCase(rs.getString("Password"))) {
                    		return "Success";
                    	}
                    	else {
                    		return "Failed";
                    	}
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Failed";
    }
}
