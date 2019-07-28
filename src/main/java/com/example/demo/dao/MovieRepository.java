package com.example.demo.dao;

import com.example.demo.entity.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * MovieRepository
 */
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    
}