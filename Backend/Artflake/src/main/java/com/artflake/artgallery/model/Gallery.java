package com.artflake.artgallery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "gallery")
public class Gallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Gallery_ID", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "Name", nullable = false, length = 255)
    private String name;

    @Column(name = "Description")
    private String description;

    @Size(max = 255)
    @Column(name = "Curator")
    private String curator;
}
