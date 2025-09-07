package com.lucymitchell.movieWatchlist.controller;
import com.lucymitchell.movieWatchlist.model.entity.Movie;
import com.lucymitchell.movieWatchlist.repository.MovieRepository;
import com.lucymitchell.movieWatchlist.service.OMBDHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final OMBDHelper ombdHelper;

    private final MovieRepository repository;

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

    @GetMapping(params = "t")
    public ResponseEntity<Object> findMovie(@RequestParam("t") String title) {
        Map<String, Object> filmDetails = ombdHelper.getMovieByTitle(title);
        return ResponseEntity.ok(filmDetails);
}
}