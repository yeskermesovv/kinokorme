package com.example.kinokorme.controller;

import com.example.kinokorme.model.Movie;
import com.example.kinokorme.model.Trailer;
import com.example.kinokorme.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{id}")
    public String getMovieById(@PathVariable Long id, Model model){
        Movie movie = movieService.getMovieById(id);
        List<Trailer> trailers = movie.getTrailers();
        model.addAttribute("movie", movie);
        model.addAttribute("trailers", trailers);
        return "movies/moviedetails";
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<?> getMovie(@PathVariable  Integer page , @PathVariable Integer size){
        return ResponseEntity.ok(movieService.getMovie(page , size));
    }

    @GetMapping
    public String getMovies(Model model){
        List<Movie> movies = movieService.getAll();
        model.addAttribute("movies", movies);
        return "movies/index";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model){
        Movie movie = new Movie();
        model.addAttribute("movie", movie);
        return "movies/moviecreateform";
    }

    @GetMapping("/{id}/edit")
    public String showUpdateForm(@PathVariable(value = "id") long id, Model model){
        Movie movie = movieService.getMovieById(id);
        model.addAttribute("movie", movie);
        return "movies/movieupdateform";
    }

    @PostMapping
    public String createMovie(@ModelAttribute("movie") Movie movie) {
        movieService.createMovie(movie);
        return "redirect:/movies";
    }

    @PutMapping
    public ResponseEntity<?> updateMovies(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.updateMovie(movie));
    }

    @DeleteMapping("/{id}")
    public String deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return "redirect:/movies";
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<?> getMovieByName(@PathVariable String title, Model model){
        model.addAttribute("title", title);
        return ResponseEntity.ok(movieService.getMovieByTitle(title));
    }

    @GetMapping("/greeting")
    public String getMovies(@RequestParam(defaultValue = "Jake") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
}
