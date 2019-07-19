package com.projectpet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projectpet.model.User;
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	//method for login
	  public User findByUsernameAndPassword(String username,String password);
	//methods for user registration
	  User save(User user); 
	  public User findByUsername(String username); 
}
