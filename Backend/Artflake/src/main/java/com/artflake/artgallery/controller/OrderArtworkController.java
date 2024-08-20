package com.artflake.artgallery.controller;

import com.artflake.artgallery.dto.OrderArtworkDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.service.OrderArtworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order-artworks")
public class OrderArtworkController {

    @Autowired
    private OrderArtworkService orderArtworkService;

    @GetMapping
    public List<OrderArtworkDto> getAllOrderArtworks() {
        return orderArtworkService.getAllOrderArtworks();
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createOrderArtwork(@RequestBody OrderArtworkDto orderArtworkDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderArtworkService.createOrderArtwork(orderArtworkDto));
    }

    @DeleteMapping("/{orderId}/{artworkId}")
    public ResponseEntity<ApiResponse> deleteOrderArtwork(@PathVariable Long orderId, @PathVariable Long artworkId) {
        return ResponseEntity.status(HttpStatus.OK).body(orderArtworkService.deleteOrderArtwork(orderId, artworkId));
    }
}
