package com.example.spring_security.services;

import com.example.spring_security.models.User;
import com.example.spring_security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user){
        userRepository.save(user);
        return user;
    }
}
