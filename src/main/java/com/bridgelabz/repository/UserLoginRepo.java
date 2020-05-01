package com.bridgelabz.repository;

import com.bridgelabz.model.LoginCredentials;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserLoginRepo implements UserRepository{
    public boolean userLogin(LoginCredentials loginCredentials) {
        Connection connection = getConnection();
        String username = loginCredentials.getUsername();
        String password = loginCredentials.getPassword();
        try {
            assert connection != null;
            Statement statement = connection.createStatement();
            String query = "SELECT firstname, lastname, username, password, mobile, email, address FROM UserDetails";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString("username").equals(username)
                        && resultSet.getString("password").equals(password)) {
                    System.out.println("\n" + resultSet.getString("firstname")
                            + " " + resultSet.getString("lastname"));
                    System.out.println("Mobile number : " + resultSet.getString("mobile"));
                    System.out.println("Email id : " + resultSet.getString("email"));
                    System.out.println("Address : " + resultSet.getString("address"));
                    statement.close();
                    connection.close();
                    return true;
                }
            }
            System.out.println("Invalid username or password");
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
}
