package com.artflake.artgallery.controller;

import com.artflake.artgallery.dto.ExhibitionArtworkDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.service.ExhibitionArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exhibition-artworks")
public class ExhibitionArtworkController {

    @Autowired
    private ExhibitionArtworkService exhibitionArtworkService;

    @GetMapping
    public List<ExhibitionArtworkDto> getAllExhibitionArtworks() {
        return exhibitionArtworkService.getAllExhibitionArtworks();
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createExhibitionArtwork(@RequestBody ExhibitionArtworkDto exhibitionArtworkDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(exhibitionArtworkService.createExhibitionArtwork(exhibitionArtworkDto));
    }

    @DeleteMapping("/{exhibitionId}/{artworkId}")
    public ResponseEntity<ApiResponse> deleteExhibitionArtwork(@PathVariable Long exhibitionId, @PathVariable Long artworkId) {
        return ResponseEntity.status(HttpStatus.OK).body(exhibitionArtworkService.deleteExhibitionArtwork(exhibitionId, artworkId));
    }
}
