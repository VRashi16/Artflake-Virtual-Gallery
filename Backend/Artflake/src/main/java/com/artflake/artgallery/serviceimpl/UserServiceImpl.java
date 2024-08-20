package com.artflake.artgallery.serviceimpl;

import com.artflake.artgallery.dto.UserDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.exception.ResourceNotFoundException;
import com.artflake.artgallery.model.Role;
import com.artflake.artgallery.model.User;
import com.artflake.artgallery.repository.UserRepository;
import com.artflake.artgallery.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public List<UserDto> getUsersByRole(Role role) {
        // Assuming you have a method in your repository to find by role
        return userRepository.findByRole(role)
                .stream()
                .map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ApiResponse createUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setRole(userDto.getRole());
        user.setUsername(userDto.getUsername());
        userRepository.save(user);
        return new ApiResponse("User created successfully");
    }

    @Override
    public ApiResponse updateUser(Long id, UserDto userDto) {
        User user = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
        modelMapper.map(userDto, user);
        userRepository.save(user);
        return new ApiResponse("Updated user successfully");
    }

    @Override
    public ApiResponse deleteUser(Long id) {
        if(userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return new ApiResponse("Deleted user successfully");
        }
        else{
            throw new ResourceNotFoundException("User not found");
        }
    }

    @Override
    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user != null ? new UserDto(user) : null;
    }
}
