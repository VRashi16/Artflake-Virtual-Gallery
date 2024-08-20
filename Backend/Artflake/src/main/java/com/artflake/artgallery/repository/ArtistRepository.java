package com.artflake.artgallery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.artflake.artgallery.model.Artist;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {
}
