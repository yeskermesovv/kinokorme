package com.example.kinokorme.model;

import com.example.kinokorme.constants.Genre;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

//@Entity
//@Table(name = "MOVIE")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "UPLOAD_DATE")
    private Date uploadDate;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Column(name = "GENRE")
    private Genre genre;

    @Column(name = "RATING")
    private Double rating;

    @Column(name = "YEAR")
    private Integer year;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "STUDIO")
    private String studio;

    @Column(name = "DURATION")
    private String duration;

    @Column(name = "VIDEO_FILE_LINK")
    private String videoFileLink;

    @Column(name = "ICON")
    private Byte[] icon;

    @Column(name = "PREVIEW_IMAGE")
    private Byte[] previewImage;

    @Column(name = "SERIES_COUNT")
    private Integer seriesCount;

    @Column(name = "SEASON_COUNT")
    private Integer seasonCount;

    @Column(name = "TAGS")
    private String tags;



}
