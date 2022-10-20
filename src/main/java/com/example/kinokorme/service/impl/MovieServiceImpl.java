package com.example.kinokorme.service.impl;

import com.example.kinokorme.model.Movie;
import com.example.kinokorme.model.Trailer;
import com.example.kinokorme.repository.MovieRepository;
import com.example.kinokorme.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private static final Logger LOG = LoggerFactory.getLogger(MovieServiceImpl.class);

    @Autowired
    private MovieRepository movieRepository;


    @Override
    public Movie updateMovie(Movie movie) {

        LOG.info("CRUD operation: UPDATE movies");
        Movie dbMovie = movieRepository.findById(movie.getId()).orElse(null);

        if (dbMovie == null){
            return null;
        }

        if (movie.getTitle() != null && !movie.getTitle().isEmpty()) {
            dbMovie.setTitle(movie.getTitle());
        }

        if (movie.getDescription() != null && !movie.getDescription().isEmpty()) {
            dbMovie.setDescription(movie.getDescription());
        }

        if (movie.getUploadDate() != null) {
            dbMovie.setUploadDate(movie.getUploadDate());
        }

        if (movie.getReleaseDate() != null) {
            dbMovie.setReleaseDate(movie.getReleaseDate());
        }

        if (movie.getGenre() != null) {
            dbMovie.setGenre(movie.getGenre());
        }

        if (movie.getRating() != null) {
            dbMovie.setRating(movie.getRating());
        }

        if (movie.getYear() != null) {
            dbMovie.setYear(movie.getYear());
        }

        if (movie.getCountry() != null && !movie.getCountry().isEmpty()) {
            dbMovie.setCountry(movie.getCountry());
        }

        if (movie.getStudio() != null && !movie.getStudio().isEmpty()) {
            dbMovie.setStudio(movie.getStudio());
        }

        if (movie.getDuration() != null && !movie.getDuration().isEmpty()) {
            dbMovie.setDuration(movie.getDuration());
        }

        if (movie.getVideoFileLink() != null && !movie.getVideoFileLink().isEmpty()) {
            dbMovie.setVideoFileLink(movie.getVideoFileLink());
        }

        if (movie.getIcon() != null) {
            dbMovie.setIcon(movie.getIcon());
        }

        if (movie.getPreviewImage() != null) {
            dbMovie.setPreviewImage(movie.getPreviewImage());
        }

        if (movie.getSeriesCount() != null) {
            dbMovie.setSeriesCount(movie.getSeriesCount());
        }

        if (movie.getSeasonCount() != null) {
            dbMovie.setSeasonCount(movie.getSeasonCount());
        }

        if (movie.getTags() != null && !movie.getTags().isEmpty()) {
            dbMovie.setTags(movie.getTags());
        }


        return movieRepository.saveAndFlush(dbMovie);
    }

    @Override
    public void deleteMovie(Long id) {
        LOG.info("CRUD operation: DELETE movies");
        movieRepository.deleteById(id);
    }

    @Override
    public Page<Movie> getMovie(Integer page, Integer size) {
        LOG.info("CRUD operation: READ movies");
        final Pageable pageableRequest = PageRequest.of(page, size);
        return movieRepository.findAll(pageableRequest);
    }

    @Override
    public Movie getMovieById(Long id) {
        LOG.info("CRUD operation: READ movies by ID");
        return movieRepository.findById(id).orElse(null);
    }

    @Override
    public List<Movie> getMovieByTitle(String title) {
        LOG.info("CRUD operation: READ movies by title");
        return movieRepository.getAllByTitle(title);
    }

    @Override
    public Movie createMovie(Movie movie) {
        LOG.info("CRUD operation: CREATE movies");
        return movieRepository.saveAndFlush(movie);
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }
}
