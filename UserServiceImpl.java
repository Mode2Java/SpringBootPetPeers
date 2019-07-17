package petstop.UserRegistration.service;

//import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import petstop.UserRegistration.model.User;
import petstop.UserRegistration.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService{
	
        @Autowired
	    private UserRepository userRepository;
	    @Override
	    public void save(User user) {
	       
	        userRepository.save(user);
	    }
	 @Override
	    public User findByUsername(String username) {
	        return userRepository.findByUsername(username);
	    }


}
