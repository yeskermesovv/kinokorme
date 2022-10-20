package com.example.kinokorme.controller;

import com.example.kinokorme.model.Movie;
import com.example.kinokorme.model.Trailer;
import com.example.kinokorme.service.MovieService;
import com.example.kinokorme.service.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/trailers")
public class TrailerController {

    @Autowired
    private TrailerService trailerService;

    @Autowired
    private MovieService movieService;


    @GetMapping("/{id}")
    public ResponseEntity<?> getTrailerById(@PathVariable Long id){
        return ResponseEntity.ok(trailerService.getTrailerById(id));
    }

    @GetMapping
    public String getTrailers(Model model){
        List<Trailer> trailers = trailerService.getTrailers();
        model.addAttribute("trailers", trailers);
        return "trailers/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model){
        Trailer trailer = new Trailer();
        List<Movie> movies = movieService.getAll();
        model.addAttribute("trailer", trailer);
        model.addAttribute("movies", movies);
        return "trailers/trailercreateform";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable(value = "id") long id, Model model){
        Trailer trailer = trailerService.getTrailerById(id);
        List<Movie> movies = movieService.getAll();
        model.addAttribute("trailer", trailer);
        model.addAttribute("movies", movies);
        return "trailers/trailerupdateform";
    }

    @PostMapping
    public String createTrailer(@ModelAttribute("trailer") Trailer trailer) {
        trailerService.createTrailer(trailer);
        return "redirect:/trailers";
    }

    @PutMapping
    public ResponseEntity<?> updateTrailer(@RequestBody Trailer trailer) {
        return ResponseEntity.ok(trailerService.updateTrailer(trailer));
    }

    @DeleteMapping("/{id}")
    public String deleteTrailerById(@PathVariable Long id) {
        trailerService.deleteTrailer(id);
        return "redirect:/trailers";
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> getTrailerByName(@PathVariable String title){
        return ResponseEntity.ok(trailerService.getTrailerByTitle(title));
    }
}
