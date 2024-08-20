package com.artflake.artgallery.controller;

import com.artflake.artgallery.dto.ArtistDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public ResponseEntity<List<ArtistDto>> getAllArtists() {
        return ResponseEntity.status(HttpStatus.OK).body(artistService.getAllArtists());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getArtistById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(artistService.getArtistById(id));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createArtist(@RequestBody ArtistDto artistDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(artistService.createArtist(artistDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateArtist(@PathVariable("id") Long id, @RequestBody ArtistDto artistDto) {
        return ResponseEntity.status(HttpStatus.OK).body(artistService.updateArtist(id, artistDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteArtist(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(artistService.deleteArtist(id));
    }
}
