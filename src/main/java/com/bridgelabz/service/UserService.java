package com.bridgelabz.service;

import com.bridgelabz.LoginCredentials;
import com.bridgelabz.model.User;

public interface UserService {
    void registerUser(User user);
    boolean checkUsernameExistence(String username);
    boolean loginUser(LoginCredentials loginCredentials);
}
