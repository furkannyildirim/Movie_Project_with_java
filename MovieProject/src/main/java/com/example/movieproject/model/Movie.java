package com.example.movieproject.model;

import com.example.movieproject.dtos.MovieDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 128, nullable = false)
    private String title;

    @Column(length = 64, nullable = false)
    private String director;

    @Column(nullable = false)
    private int year;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private List<Classification> classifications;

    public MovieDTO viewAsMovieDTO(){
        return new MovieDTO(this.id,this.title, this.director, this.year);
    }

    public Movie(String title, String director, int year) {
        this.title = title;
        this.director = director;
        this.year = year;
    }
    public Movie() {}

    public Movie(long id, String title, String director, int year) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.year = year;
    }
}
