package com.artflake.artgallery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "artist")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Artist_ID", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "Name", nullable = false, length = 50)
    private String name;

    @Column(name = "Bio")
    private String bio;

    @Size(max = 255)
    @Column(name = "Profile_Picture")
    private String profilePicture;

}
