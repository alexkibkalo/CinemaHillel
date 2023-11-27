package com.ua.service.authorization.util;

import com.ua.model.User;

import java.util.List;

public class MockGenerator {

    public static User generateUser(String username, String password){
        User user = new User();
        user.setId(1L);
        user.setUsername(username);
        user.setPassword(password);
        user.setAuthorized(false);
        user.setTickets(List.of());
        return user;
    }
}
