package com.example.spring_security.controllers;

import com.example.spring_security.models.User;
import com.example.spring_security.repositories.UserRepository;
import com.example.spring_security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public User insertUser(@RequestBody User user){
        return userService.saveUser(user);
    }


}
