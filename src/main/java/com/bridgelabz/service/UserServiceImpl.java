package com.bridgelabz.service;

import com.bridgelabz.model.LoginCredentials;
import com.bridgelabz.model.User;
import com.bridgelabz.repository.*;

import java.time.LocalDate;

public class UserServiceImpl implements UserService{
    AddUserRepo addUserRepo;

    public UserServiceImpl() {
        this.addUserRepo = new AddUserRepo();
    }

    @Override
    public void registerUser(User user) {
        user.setRegisterDate(LocalDate.now());
        addUserRepo.addUser(user);
    }

    public boolean checkUsernameExistence(String username) {
        return new DataPresenceRepo().checkUsernamePresence(username);
    }

    public boolean loginUser(LoginCredentials loginCredentials) {
        return new UserLoginRepo().userLogin(loginCredentials);
    }
}
