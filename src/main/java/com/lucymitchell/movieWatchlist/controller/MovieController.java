package com.lucymitchell.movieWatchlist.controller;
import com.lucymitchell.movieWatchlist.model.entity.Movie;
import com.lucymitchell.movieWatchlist.repository.MovieRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieRepository repository;

    public MovieController(MovieRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        List<Movie> movies = repository.findAll();
        System.out.println("Movies returned: " + movies);
        return movies;
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) {
        System.out.println("add");
        return repository.save(movie);
    }
}