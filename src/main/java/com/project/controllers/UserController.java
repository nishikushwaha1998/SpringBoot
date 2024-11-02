package com.project.controllers;

import com.project.entities.Users;
import com.project.exception.ResourceNotFoundException;
import com.project.payload.ApiResponse;
import com.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody Users users) {
        try {
            Users savedUser = userService.saveUser(users);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(ApiResponse.builder()
                            .message("User created successfully")
                            .success(true)
                            .status(HttpStatus.CREATED)
                            .build());
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.builder()
                            .message(ex.getMessage())
                            .success(false)
                            .status(HttpStatus.NOT_FOUND)
                            .build());
        }
    }


    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse> getSingleUser(@PathVariable String userId) {
        try {
            Users savedUser = userService.getUser(userId);
            return ResponseEntity.status(HttpStatus.OK)
                    .body(ApiResponse.builder()
                            .message("User created successfully")
                            .success(true)
                            .status(HttpStatus.CREATED)
                            .build());
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(ApiResponse.builder()
                            .message(ex.getMessage())
                            .success(false)
                            .status(HttpStatus.NOT_FOUND)
                            .build());
        }
    }


    @GetMapping
    public ResponseEntity<List<Users>> getAllUser() {
        List<Users> allusers = userService.getAllUser();
        return ResponseEntity.ok(allusers);
    }
}
