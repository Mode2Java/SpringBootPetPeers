package petstop.UserRegistration.service;

import petstop.UserRegistration.model.User;

public interface UserService {
    void save(User user);
    User findByUsername(String username);
}
