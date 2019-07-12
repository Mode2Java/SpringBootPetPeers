package com.security.petpeers.service;

import com.security.petpeers.model.User;

public interface UserService 
{
    void save(User user);

    User findByUsername(String username);
}