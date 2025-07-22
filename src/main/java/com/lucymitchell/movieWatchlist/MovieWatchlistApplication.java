package com.lucymitchell.movieWatchlist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "com.lucymitchell.movieWatchlist")
@EntityScan(basePackages = "com.lucymitchell.movieWatchlist.model.entity")

public class MovieWatchlistApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieWatchlistApplication.class, args);
	}

}
