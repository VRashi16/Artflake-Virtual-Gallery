package com.artflake.artgallery.controller;

import com.artflake.artgallery.dto.ArtworkGalleryDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.service.ArtworkGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artwork-galleries")
public class ArtworkGalleryController {

    @Autowired
    private ArtworkGalleryService artworkGalleryService;

    @GetMapping
    public List<ArtworkGalleryDto> getAllArtworkGalleries() {
        return artworkGalleryService.getAllArtworkGalleries();
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createArtworkGallery(@RequestBody ArtworkGalleryDto artworkGalleryDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(artworkGalleryService.createArtworkGallery(artworkGalleryDto));
    }

    @DeleteMapping("/{artworkId}/{galleryId}")
    public ResponseEntity<ApiResponse> deleteArtworkGallery(@PathVariable Long artworkId, @PathVariable Long galleryId) {
        return ResponseEntity.status(HttpStatus.OK).body(artworkGalleryService.deleteArtworkGallery(artworkId, galleryId));
    }
}
