package com.artflake.artgallery.controller;

import com.artflake.artgallery.dto.UserDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.model.Role;
import com.artflake.artgallery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserById(id));
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<UserDto>> getUsersByRole(@PathVariable Role role) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsersByRole(role));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> registerUser(@RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(userDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateUser(@PathVariable long id, @RequestBody UserDto userDto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id));
    }
}
