package com.artflake.artgallery.repository;

import com.artflake.artgallery.model.Artist;
import com.artflake.artgallery.model.Artwork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArtworkRepository extends JpaRepository<Artwork, Long> {
    List<Artwork> findByArtist(Artist artist);
}
