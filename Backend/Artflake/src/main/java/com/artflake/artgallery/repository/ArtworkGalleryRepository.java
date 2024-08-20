package com.artflake.artgallery.repository;

import com.artflake.artgallery.model.ArtworkGallery;
import com.artflake.artgallery.model.ArtworkGalleryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtworkGalleryRepository extends JpaRepository<ArtworkGallery, ArtworkGalleryId> {
}
