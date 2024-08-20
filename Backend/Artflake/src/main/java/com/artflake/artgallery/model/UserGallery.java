package com.artflake.artgallery.model;

import com.artflake.artgallery.model.UserGalleryId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "User_Gallery")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@IdClass(UserGalleryId.class)
public class UserGallery {

    @Id
    @ManyToOne
    @JoinColumn(name = "User_ID", nullable = false)
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "Gallery_ID", nullable = false)
    private Gallery gallery;
}
