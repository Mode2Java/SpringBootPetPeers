package com.projectpet.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.projectpet.model.User;

public interface UserService extends UserDetailsService {
	 public User searchUser(String username,String password);
	 void save(User user); 
	 public User findByUsername(String username);
}
