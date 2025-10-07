package com.example.movieproject.services;

import com.example.movieproject.dtos.MovieDTO;
import com.example.movieproject.model.Classification;
import com.example.movieproject.model.Movie;

import java.util.List;

public interface MovieServices {

        List<MovieDTO> getAllMovies();
        MovieDTO getMovieById(Long id);
        MovieDTO addMovie(MovieDTO movie);
        MovieDTO updateMovie(Long id, MovieDTO movieDetails);
        void deleteMovie(Long id);


}
