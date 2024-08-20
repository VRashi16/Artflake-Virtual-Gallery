package com.artflake.artgallery.repository;

import com.artflake.artgallery.model.ExhibitionArtwork;
import com.artflake.artgallery.model.ExhibitionArtworkId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitionArtworkRepository extends JpaRepository<ExhibitionArtwork, ExhibitionArtworkId> {
}
