package com.artflake.artgallery.model;

import com.artflake.artgallery.model.Artwork;
import com.artflake.artgallery.model.ArtworkGalleryId;
import com.artflake.artgallery.model.Gallery;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Artwork_Gallery")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@IdClass(ArtworkGalleryId.class)
public class ArtworkGallery {

    @Id
    @ManyToOne
    @JoinColumn(name = "Artwork_ID", nullable = false)
    private Artwork artwork;

    @Id
    @ManyToOne
    @JoinColumn(name = "Gallery_ID", nullable = false)
    private Gallery gallery;
}
