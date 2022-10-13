package com.example.kinokorme.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


//@Entity
//@Table(name = "TRAILER")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Trailer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "DURATION")
    private String duration;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RELEASE_DATE")
    private Date releaseDate;

    @Column(name = "UPLOAD_DATE")
    private Date uploadDate;

    @ManyToOne
    @JoinColumn(name = "MOVIE" , referencedColumnName = "ID")
    private Movie movie;

}

