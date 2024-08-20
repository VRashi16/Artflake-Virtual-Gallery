package com.artflake.artgallery.model;

import java.io.Serializable;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderArtworkId implements Serializable {
    private Long order;
    private Long artwork;
}
