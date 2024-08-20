package com.artflake.artgallery.repository;

import com.artflake.artgallery.model.Cart;
import com.artflake.artgallery.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCartUserId(Long userId);

    List<CartItem> findByCart(Cart cart);

    List<CartItem> findByCartId(Long cartId);

}

