package com.project.services.impl;

import com.project.entities.Users;
import com.project.exception.ResourceNotFoundException;
import com.project.repositories.UserRepository;
import com.project.services.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public Users saveUser(Users users) {
        //generate unique userId
        String randomUserID = UUID.randomUUID().toString();
        users.setUserId(randomUserID);
        return userRepository.save(users);
    }

    @Override
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Users getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on server !! :"+userId));
    }
}
