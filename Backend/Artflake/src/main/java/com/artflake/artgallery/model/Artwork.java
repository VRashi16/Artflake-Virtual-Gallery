package com.artflake.artgallery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "artwork")
public class Artwork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Artwork_ID", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "Title", nullable = false, length = 255)
    private String title;

    @Column(name = "Description")
    private String description;

    @Size(max = 255)
    @Column(name = "Image")
    private String image;

    @Column(name = "Price", precision = 10, scale = 2)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "Artist_ID", nullable = false)
    private Artist artist;
}
