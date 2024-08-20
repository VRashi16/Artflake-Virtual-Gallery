package com.artflake.artgallery.controller;

import com.artflake.artgallery.dto.ArtworkDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.service.ArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artworks")
public class ArtworkController {

    @Autowired
    private ArtworkService artworkService;

    @GetMapping
    public ResponseEntity<List<ArtworkDto>> getAllArtworks() {
        List<ArtworkDto> artworks = artworkService.getAllArtworks();
        return ResponseEntity.status(HttpStatus.OK).body(artworks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtworkDto> getArtworkById(@PathVariable("id") Long id) {
        ArtworkDto artwork = artworkService.getArtworkById(id);
        return ResponseEntity.status(HttpStatus.OK).body(artwork);
    }

    @GetMapping("/artist/{artistId}")
    public ResponseEntity<List<ArtworkDto>> getArtworksByArtistId(@PathVariable("artistId") Long artistId) {
        List<ArtworkDto> artworks = artworkService.getArtworksByArtistId(artistId);
        return ResponseEntity.status(HttpStatus.OK).body(artworks);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createArtwork(@RequestBody ArtworkDto artworkDto) {
        ApiResponse response = artworkService.createArtwork(artworkDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updateArtwork(@PathVariable("id") Long id, @RequestBody ArtworkDto artworkDto) {
        ApiResponse response = artworkService.updateArtwork(id, artworkDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteArtwork(@PathVariable("id") Long id) {
        ApiResponse response = artworkService.deleteArtwork(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
