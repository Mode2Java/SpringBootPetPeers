package petstop.UserRegistration.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import petstop.UserRegistration.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User save(User user);
	public User findByUsername(String username);
}

