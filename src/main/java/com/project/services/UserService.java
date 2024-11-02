package com.project.services;

import com.project.entities.Users;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {

    Users saveUser(Users users);

    List<Users> getAllUser();

    Users getUser(String userId);


}
