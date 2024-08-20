package com.artflake.artgallery.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GalleryDto {

    @Size(max = 255)
    @NotNull
    private String name;

    private String description;

    @Size(max = 255)
    private String curator;
}
