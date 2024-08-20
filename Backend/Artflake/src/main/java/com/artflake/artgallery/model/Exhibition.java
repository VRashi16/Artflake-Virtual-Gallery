package com.artflake.artgallery.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "exhibition")
public class Exhibition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Exhibition_ID", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "Title", nullable = false, length = 255)
    private String title;

    @Column(name = "Start_Date")
    private java.sql.Date startDate;

    @Column(name = "End_Date")
    private java.sql.Date endDate;

    @ManyToOne
    @JoinColumn(name = "Gallery_ID")
    private Gallery gallery;
}
