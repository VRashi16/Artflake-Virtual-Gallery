package com.artflake.artgallery.repository;

import com.artflake.artgallery.model.UserGallery;
import com.artflake.artgallery.model.UserGalleryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserGalleryRepository extends JpaRepository<UserGallery, UserGalleryId> {
}
