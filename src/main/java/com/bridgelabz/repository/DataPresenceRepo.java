package com.bridgelabz.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataPresenceRepo implements UserRepository{
    public boolean checkUsernamePresence(String username) {
        Connection connection = getConnection();
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            String query = "SELECT username FROM UserDetails";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString("username").equals(username))
                    return true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
}
