package com.artflake.artgallery.model;

import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserGalleryId implements Serializable {
    private Long user;
    private Long gallery;
}
