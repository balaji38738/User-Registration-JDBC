package com.bridgelabz.repository;

import com.bridgelabz.model.*;
import java.sql.*;

public class UserRepository {
    public void addUser(User user) {
        BasicDetails basicDetails = user.getBasicDetails();
        ContactDetails contactDetails = user.getContactDetails();
        LoginCredentials loginCredentials = user.getLoginCredentials();

        Connection connection = getConnection();
        try {
            assert connection != null;
            PreparedStatement statement = connection.prepareStatement("INSERT INTO UserDetails VALUES(?,?,?,?,?,?,?,?)");
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

    private static Connection getConnection() {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/UserData",
                    "root", "balaji1729");
        } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
        }
        return null;
    }
}
