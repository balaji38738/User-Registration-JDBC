package com.bridgelabz.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface UserRepository {
    default Connection getConnection() {
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
