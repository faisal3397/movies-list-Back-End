package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Movie;

/**
 * MovieService
 */
public interface MovieService {

    public List<Movie> findAll();

    public Movie findById(int theId);

    public void save(Movie theMovie);

    public void deleteById(int theId);
}