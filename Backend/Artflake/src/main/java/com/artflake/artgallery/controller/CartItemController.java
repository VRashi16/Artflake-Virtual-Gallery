package com.artflake.artgallery.controller;

import com.artflake.artgallery.dto.CartItemDto;
import com.artflake.artgallery.exception.ApiResponse;
import com.artflake.artgallery.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart-items")
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    @GetMapping
    public List<CartItemDto> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @GetMapping("/{cartId}/items")
    public ResponseEntity<List<CartItemDto>> getCartItemsByCartId(@PathVariable("cartId") Long cartId) {
        List<CartItemDto> cartItems = cartItemService.getCartItemsByCartId(cartId);
        return ResponseEntity.status(HttpStatus.OK).body(cartItems);
    }

    @PostMapping
    public ResponseEntity<ApiResponse> createCartItem(@RequestBody CartItemDto cartItemDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cartItemService.createCartItem(cartItemDto));
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Long cartItemId) {
        return ResponseEntity.status(HttpStatus.OK).body(cartItemService.deleteCartItem(cartItemId));
    }
}

