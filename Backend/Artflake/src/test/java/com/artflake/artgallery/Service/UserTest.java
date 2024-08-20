package com.artflake.artgallery.service;

import com.artflake.artgallery.dto.UserDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.model.Role;
import com.artflake.artgallery.model.User;
import com.artflake.artgallery.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class UserTest {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @MockBean
    private UserRepository userRepository;

    @Test
    void getAllUsersTest() {
        when(userRepository.findAll()).thenReturn(Stream.of(
                        new User(6L, "Rahul", "rahuls", "rahul@gmail.com", Role.ADMIN),
                        new User(7L,"John", "johns", "john@gmail.com", Role.ARTIST))
                .collect(Collectors.toList()));

        assertEquals(2, userService.getAllUsers().size());
    }

    @Test
    void findUserByIdTest() {
        // Prepare mock data
        User user = new User(11L, "Rohit", "rohitinchale", "rohit@gmail.com", Role.VISITOR);
        UserDto userDto = modelMapper.map(user, UserDto.class);

        // Mock the repository call
        Mockito.when(userRepository.findById(11L)).thenReturn(Optional.of(user));

        // Call the service method
        UserDto returnedUserDto = userService.getUserById(11L);

        // Assert that the returned user data matches the mock data
        assertEquals(userDto.getId(), returnedUserDto.getId());
        assertEquals(userDto.getUsername(), returnedUserDto.getUsername());
        assertEquals(userDto.getEmail(), returnedUserDto.getEmail());
        assertEquals(userDto.getRole(), returnedUserDto.getRole());
    }

    @Test
    void addUserTest() {
        UserDto userDto = new UserDto(5L, "Rahul Soni", "Rahuls", "r@gmail.com", Role.ADMIN);
        User user = modelMapper.map(userDto, User.class);
        Mockito.when(userRepository.save(user)).thenReturn(user);
        ApiResponse msg = userService.createUser(userDto);
        assertEquals("Inserted user successfully", msg.getMessage());
    }

    @Test
    void updateUserTest() {
        UserDto userDto = new UserDto(5L, "Rahul Soni", "Rahuls", "r@gmail.com", Role.ADMIN);

        User user = modelMapper.map(userDto, User.class);

        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        user.setUsername("Updated Rahul");
        Mockito.when(userRepository.save(user)).thenReturn(user);

        ApiResponse response = userService.updateUser(user.getId(), userDto);

        assertEquals("Updated user successfully", response.getMessage());
    }

//    @Test
//    void deleteUserTest() {
//        // Mocking the user that exists in the database
//        UserDto userdto = new UserDto(100L, "Rahul Soni", "Rahuls", "r@gmail.com", Role.ADMIN);
//        User user = modelMapper.map(userdto, User.class);
//        userRepository.save(user);
//
//        // Call the service method to delete the user
//        userService.deleteUser(userdto.getId());
//
//        // Verify that the repository deleteById method was called once with the correct ID
//        verify(userRepository, times(1)).deleteById(userdto.getId());
//    }

}
