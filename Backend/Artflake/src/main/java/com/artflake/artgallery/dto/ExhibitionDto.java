package com.artflake.artgallery.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
public class ExhibitionDto {

    @NotNull
    private String title;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private Long galleryId; // ID of the associated gallery
}
