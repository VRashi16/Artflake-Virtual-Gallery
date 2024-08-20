package com.artflake.artgallery.service;

import com.artflake.artgallery.dto.UserDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.model.Role;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    List<UserDto> getUsersByRole(Role role);

    ApiResponse createUser(UserDto userDto);

    ApiResponse updateUser(Long id, UserDto userDto);

    ApiResponse deleteUser(Long id);

    UserDto getUserByEmail(String email);

}
