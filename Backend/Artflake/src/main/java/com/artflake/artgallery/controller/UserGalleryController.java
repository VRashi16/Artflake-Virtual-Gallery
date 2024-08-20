package com.artflake.artgallery.controller;

import com.artflake.artgallery.dto.UserGalleryDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.service.UserGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-galleries")
public class UserGalleryController {

    @Autowired
    private UserGalleryService userGalleryService;

    @GetMapping
    public List<UserGalleryDto> getAllUserGalleries() {
        return userGalleryService.getAllUserGalleries();
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createUserGallery(@RequestBody UserGalleryDto userGalleryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userGalleryService.createUserGallery(userGalleryDto));
    }

    @DeleteMapping("/{userId}/{galleryId}")
    public ResponseEntity<ApiResponse> deleteUserGallery(@PathVariable Long userId, @PathVariable Long galleryId) {
        return ResponseEntity.status(HttpStatus.OK).body(userGalleryService.deleteUserGallery(userId, galleryId));
    }
}
