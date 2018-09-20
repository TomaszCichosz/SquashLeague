package com.groupproject.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserFacade {

    private UserRepository userRepository;

    @Autowired
    public UserFacade(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByUuid(String uuid) {
        return userRepository.findOneByUuid(uuid);
    }

    public User getUserByLogin(String login) {
        return userRepository.findOneByLogin(login);
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }


}
