package com.artflake.artgallery.repository;

import com.artflake.artgallery.model.Exhibition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExhibitionRepository extends JpaRepository<Exhibition, Long> {
}
