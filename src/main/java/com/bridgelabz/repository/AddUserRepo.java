package com.bridgelabz.repository;

import com.bridgelabz.model.*;
import java.sql.*;

public class AddUserRepo implements UserRepository{
    public void addUser(User user) {
        BasicDetails basicDetails = user.getBasicDetails();
        ContactDetails contactDetails = user.getContactDetails();
        LoginCredentials loginCredentials = user.getLoginCredentials();
        Connection connection = getConnection();
        try {
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO UserDetails VALUES(?,?,?,?,?,?,?,?)");
            statement.setString(1, basicDetails.getFirstName());
            statement.setString(2, basicDetails.getLastName());
            statement.setDate(3, Date.valueOf(user.getRegisterDate()));
            statement.setString(4, contactDetails.getMobileNumber());
            statement.setString(5, contactDetails.getEmail());
            statement.setString(6, loginCredentials.getUsername());
            statement.setString(7, loginCredentials.getPassword());
            statement.setString(8, user.getAddress());
            statement.executeUpdate();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
