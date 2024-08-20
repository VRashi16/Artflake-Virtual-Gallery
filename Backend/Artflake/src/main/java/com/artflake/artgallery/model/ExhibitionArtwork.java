package com.artflake.artgallery.model;

import com.artflake.artgallery.model.ExhibitionArtworkId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Exhibition_Artwork")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@IdClass(ExhibitionArtworkId.class)
public class ExhibitionArtwork {

    @Id
    @ManyToOne
    @JoinColumn(name = "Exhibition_ID", nullable = false)
    private Exhibition exhibition;

    @Id
    @ManyToOne
    @JoinColumn(name = "Artwork_ID", nullable = false)
    private Artwork artwork;
}
