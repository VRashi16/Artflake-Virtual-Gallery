package com.artflake.artgallery.repository;

import com.artflake.artgallery.model.OrderArtwork;
import com.artflake.artgallery.model.OrderArtworkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderArtworkRepository extends JpaRepository<OrderArtwork, OrderArtworkId> {
}
