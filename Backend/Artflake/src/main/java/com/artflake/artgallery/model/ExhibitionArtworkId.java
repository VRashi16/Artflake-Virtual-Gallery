package com.artflake.artgallery.model;

import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ExhibitionArtworkId implements Serializable {
    private Long exhibition;
    private Long artwork;
}
