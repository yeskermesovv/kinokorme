package com.example.kinokorme.controller;

import com.example.kinokorme.model.Movie;
import com.example.kinokorme.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getMovieById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<?> getMovie(@PathVariable  Integer page , @PathVariable Integer size){
        return ResponseEntity.ok(movieService.getMovie(page , size));
    }

    @PostMapping
    public ResponseEntity<?> createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.createMovie(movie));
    }

    @PutMapping
    public ResponseEntity<?> updateMovies(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovie(movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> getMovieByName(@PathVariable String title, Model model){
        model.addAttribute("title", title);
        return ResponseEntity.ok(movieService.getMovieByTitle(title));
    }

    @GetMapping("greeting")
    public String getMovies(@RequestParam(defaultValue = "Jake") String name, Model model) {
        model.addAttribute("name", name);
        return "/greeting";
    }
}
