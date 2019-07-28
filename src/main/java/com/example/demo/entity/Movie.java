package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Movie
 */
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="genre")
    private String genre;

    @Column(name="plot")
    private String plot;

    @Column(name="poster_url")
    private String posterUrl;

    @Column(name="title")
    private String title;

    @Column(name="year")
    private String year;
    
    public Movie() {

    }

    public Movie(String genre, String plot, String posterUrl, String title, String year) {
        this.genre = genre;
        this.plot = plot;
        this.posterUrl = posterUrl;
        this.title = title;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie [genre=" + genre + ", id=" + id + ", plot=" + plot + ", posterUrl=" + posterUrl + ", title="
                + title + ", year=" + year + "]";
    }

    
}