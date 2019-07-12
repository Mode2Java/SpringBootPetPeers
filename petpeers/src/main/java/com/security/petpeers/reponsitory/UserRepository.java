package com.security.petpeers.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.petpeers.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}