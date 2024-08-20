package com.artflake.artgallery.model;

import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ArtworkGalleryId implements Serializable {
    private Long artwork;
    private Long gallery;
}
