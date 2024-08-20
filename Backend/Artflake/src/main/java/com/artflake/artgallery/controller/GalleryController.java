package com.artflake.artgallery.controller;

import com.artflake.artgallery.dto.GalleryDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gallery")
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    @GetMapping
    public ResponseEntity<List<GalleryDto>> getAllGalleries() {
        List<GalleryDto> galleries = galleryService.getAllGalleries();
        return ResponseEntity.status(HttpStatus.OK).body(galleries);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GalleryDto> getGalleryById(@PathVariable("id") Long id) {
        GalleryDto gallery = galleryService.getGalleryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(gallery);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createGallery(@RequestBody GalleryDto galleryDto) {
        ApiResponse response = galleryService.createGallery(galleryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateGallery(@PathVariable("id") Long id, @RequestBody GalleryDto galleryDto) {
        ApiResponse response = galleryService.updateGallery(id, galleryDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteGallery(@PathVariable("id") Long id) {
        ApiResponse response = galleryService.deleteGallery(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
