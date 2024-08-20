package com.artflake.artgallery.controller;

import com.artflake.artgallery.dto.UserDto;
import com.artflake.artgallery.model.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class UserTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper mapper;
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void mockGetAllUsers() throws Exception {
        MvcResult result = mockMvc.perform(get("/user").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void mockGetUserById() throws Exception {
        // Perform the GET request
        MvcResult result = mockMvc.perform(get("/user/2")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())  // Expect 200 OK
                .andReturn();

        // Assert that the response status is 200 OK
        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void mockAddUser() throws Exception {
        UserDto userDto = new UserDto(5L, "Rahul", "rahuls", "rahuls@gmail.com", Role.ADMIN);
        String jsonRequest = mapper.writeValueAsString(userDto);

        MvcResult result = mockMvc.perform(post("/user").content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated()).andReturn();
        assertEquals(201, result.getResponse().getStatus());
    }

//    @Test
//    void mockUpdateUser() throws Exception{
//        UserDto userDto = new UserDto(5L, "Megha", "meghas", "meghas@gmail.com", Role.ARTIST);
//        String jsonRequest = mapper.writeValueAsString(userDto);
//
//        // Create the user via POST
//        mockMvc.perform(post("/user")
//                        .content(jsonRequest).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isCreated())  // Expect 201 Created for POST
//                .andReturn();
//
//        // Update the user
//        UserDto updatedUserDto = new UserDto(5L, "Megha", "meghas", "meghasoni@gmail.com", Role.ARTIST);
//        String jsonRequest1 = mapper.writeValueAsString(updatedUserDto);
//
//        // Perform the update via PUT
//        MvcResult result1 = mockMvc.perform(put("/user/5")
//                        .content(jsonRequest1).contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())  // Expect 200 OK for PUT (update)
//                .andReturn();
//
//        // Assert that the response status is 200 OK
//        assertEquals(200, result1.getResponse().getStatus());
//    }

    @Test
    void mockDeleteUser() throws Exception {
        MvcResult result = mockMvc.perform(delete("/user/1"))
                .andExpect(status().isOk()).andReturn();
        assertEquals(200, result.getResponse().getStatus());
    }
}
