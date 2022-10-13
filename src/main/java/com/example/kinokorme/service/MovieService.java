package com.example.kinokorme.service;

import com.example.kinokorme.model.Movie;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MovieService {

    Movie updateMovie(Movie movie);

    void deleteMovie(Long id);

    Page<Movie> getMovie(Integer page , Integer size);

    Movie getMovieById(Long id);

    List<Movie> getMovieByTitle(String title);

    Movie createMovie(Movie movie);
}
