package com.example.kinokorme.service;

import com.example.kinokorme.model.Trailer;

import java.util.List;

public interface TrailerService {

    Trailer updateTrailer(Trailer trailer);

    void deleteTrailer(Long id);

    List<Trailer> getTrailers();

    Trailer getTrailerById(Long id);

    List<Trailer> getTrailerByTitle(String title);

    Trailer createTrailer(Trailer trailer);
}
