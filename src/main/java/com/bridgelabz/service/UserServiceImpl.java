package com.bridgelabz.service;

import com.bridgelabz.model.LoginCredentials;
import com.bridgelabz.model.User;
import com.bridgelabz.repository.UserRepository;
import java.time.LocalDate;

public class UserServiceImpl implements UserService{
    UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepository();
    }

    @Override
    public void registerUser(User user) {
        user.setRegisterDate(LocalDate.now());
        userRepository.addUser(user);
    }

    public boolean checkUsernameExistence(String username) {
        return new UserRepository().checkUsernamePresence(username);
    }

    public boolean loginUser(LoginCredentials loginCredentials) {
        return new UserRepository().userLogin(loginCredentials);
    }
}
