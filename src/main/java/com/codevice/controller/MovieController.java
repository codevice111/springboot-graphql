package com.codevice.controller;

import com.codevice.model.Movie;
import com.codevice.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @QueryMapping
    public ResponseEntity<List<Movie>> getMovie() {
        return ResponseEntity.ok(movieService.findAllMovies());
    }

    @MutationMapping
    public Movie addMovie(@Argument MovieInput movieInput) {
        Movie movie = new Movie();
        movie.setMovieName(movieInput.getMovieName());
        movie.setRatings(movieInput.getRatings());
        movie.setVerdict(movieInput.getVerdict());
        movie.setCategory(movieInput.getCategory());
        return movieRepository.save(movie);
    }
}
