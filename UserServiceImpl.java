package com.projectpet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.projectpet.model.User;
import com.projectpet.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	    @Autowired
	    private UserRepository userRepository;

	

	@Override
	public User searchUser(String username, String password) {
		// TODO Auto-generated method stub
		User user=userRepository.findByUsernameAndPassword(username,password);
		//if (user == null) {
           // throw new UsernameNotFoundException("Invalid username or password");}
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	 @Override 
	    public void save(User user) {  
	        userRepository.save(user); 
	    } 
	 @Override 
	    public User findByUsername(String username) { 
	        return userRepository.findByUsername(username); 
	    } 
}
