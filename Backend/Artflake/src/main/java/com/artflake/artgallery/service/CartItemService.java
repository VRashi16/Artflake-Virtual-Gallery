package com.artflake.artgallery.service;

import com.artflake.artgallery.dto.CartItemDto;
import com.artflake.artgallery.exception.ApiResponse;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface CartItemService {

    List<CartItemDto> getAllCartItems();

    ApiResponse createCartItem(CartItemDto cartItemDto);

    ApiResponse deleteCartItem(Long cartItemId);

    List<CartItemDto> getCartItemsByCartId(Long cartId);
}

