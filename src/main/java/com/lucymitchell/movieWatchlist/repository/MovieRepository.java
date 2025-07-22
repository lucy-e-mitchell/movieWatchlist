package com.lucymitchell.movieWatchlist.repository;

import com.lucymitchell.movieWatchlist.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}