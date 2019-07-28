package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.dao.MovieRepository;
import com.example.demo.entity.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * MovieServiceImpl
 */
@Service
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepo;

    @Autowired
    public MovieServiceImpl(MovieRepository theMovieRepository) {
        this.movieRepo = theMovieRepository;
    }

    @Override
    public List<Movie> findAll() {
        return movieRepo.findAll();
    }

    @Override
    public Movie findById(int theId) {
        Optional<Movie> result = movieRepo.findById(theId);

        Movie theMovie = null;

        if(result.isPresent()) {
            theMovie = result.get();
        } else {
            throw new RuntimeException("The Movie with the ID "+theId+" is not found");
        }
 

        return theMovie;
    }

    @Override
    public void save(Movie theMovie) {
        movieRepo.save(theMovie);
    }

	@Override
	public void deleteById(int theId) {
		movieRepo.deleteById(theId);
	}

    
}