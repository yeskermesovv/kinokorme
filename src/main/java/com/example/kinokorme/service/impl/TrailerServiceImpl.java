package com.example.kinokorme.service.impl;

import com.example.kinokorme.model.Movie;
import com.example.kinokorme.model.Trailer;
import com.example.kinokorme.repository.TrailerRepository;
import com.example.kinokorme.service.TrailerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrailerServiceImpl implements TrailerService {


    private static final Logger LOG = LoggerFactory.getLogger(TrailerServiceImpl.class);

    @Autowired
    private TrailerRepository trailerRepository;

    @Override
    public Trailer updateTrailer(Trailer trailer) {
        LOG.info("CRUD operation: UPDATE trailer");
        Trailer dbTrailer = trailerRepository.findById(trailer.getId()).orElse(null);

        if (trailer.getTitle() != null && !trailer.getTitle().isEmpty()) {
            dbTrailer.setTitle(trailer.getTitle());
        }

        if (trailer.getDuration() != null && !trailer.getDuration().isEmpty()) {
            dbTrailer.setDuration(trailer.getDuration());
        }

        if (trailer.getDescription() != null && !trailer.getDescription().isEmpty()) {
            dbTrailer.setDescription(trailer.getDescription());
        }

        if (trailer.getReleaseDate() != null ) {
            dbTrailer.setReleaseDate(trailer.getReleaseDate());
        }

        if (trailer.getUploadDate() != null ) {
            dbTrailer.setUploadDate(trailer.getUploadDate());
        }

        if (trailer.getMovie() != null ) {
            dbTrailer.setMovie(trailer.getMovie());
        }

        return trailerRepository.saveAndFlush(dbTrailer);
    }

    @Override
    public void deleteTrailer(Long id) {

        LOG.info("CRUD operation: DELETE trailer");
        trailerRepository.deleteById(id);
    }

    @Override
    public void deleteTrailerByMovie(Movie movie) {
        System.out.println("movie = " + movie.getTrailers());
        movie.getTrailers().clear();
    }

    @Override
    public List<Trailer> getTrailers() {
        LOG.info("CRUD operation: READ trailer");
        return trailerRepository.findAll();
    }

    @Override
    public Trailer getTrailerById(Long id) {
        LOG.info("CRUD operation: READ trailer by ID");
        return trailerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Trailer> getTrailerByTitle(String title) {
        LOG.info("CRUD operation: READ trailer by name");
        return trailerRepository.getAllByTitle(title);
    }

    @Override
    public Trailer createTrailer(Trailer trailer) {
        LOG.info("CRUD operation: CREATE trailer");
        return trailerRepository.saveAndFlush(trailer);
    }
}
