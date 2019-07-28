package com.example.demo.controller;


import java.util.List;

import com.example.demo.entity.Movie;
import com.example.demo.service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ApplicationController
 */
@RestController
public class ApplicationController {

    private MovieService movieService;

    @Autowired
    public ApplicationController(MovieService theMovieService) {
        this.movieService = theMovieService;
    }


    @GetMapping("/")
    public String showIndex() {
        return "Hello World";
    }

    @GetMapping("/movies")
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovie(@PathVariable int movieId) {
        Movie theMovie = movieService.findById(movieId);

        return theMovie;
    }

    @PostMapping("/movies")
    public Movie addMovie(@RequestBody Movie theMovie) {
        // also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
        
        theMovie.setId(0);
        movieService.save(theMovie);
        return theMovie;
    }

    @PutMapping("/movies")
    public Movie updateMovie(@RequestBody Movie theMovie) {
        movieService.save(theMovie);
        return theMovie;
    }

    @DeleteMapping("/movies/{movieId}")
    public String deleteMovie(@PathVariable int movieId) {
        Movie theMovie = movieService.findById(movieId); // to check if there is a movie
        if(theMovie == null) {
            return "Movie with the Id "+movieId+" not found";
        }
        movieService.deleteById(movieId);

        return "Deleted Movie with the ID "+movieId;
    }
    
}