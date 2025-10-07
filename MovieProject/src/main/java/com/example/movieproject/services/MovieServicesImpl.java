package com.example.movieproject.services;

import com.example.movieproject.dtos.MovieDTO;
import com.example.movieproject.exception.ErrorMessages;
import com.example.movieproject.exception.ResourceAlreadyExistsException;
import com.example.movieproject.exception.ResourceNotFoundException;
import com.example.movieproject.model.Classification;
import com.example.movieproject.model.Movie;
import com.example.movieproject.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.DuplicateFormatFlagsException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServicesImpl implements MovieServices {

    private final MovieRepository movieRepository;

    public MovieServicesImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream().map(Movie::viewAsMovieDTO).collect(Collectors.toList());

    }

    @Override
    public MovieDTO getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(()->new ResourceAlreadyExistsException(ErrorMessages.ERROR_MOVIE_NOT_FOUND)).viewAsMovieDTO();
    }

    @Override
    public MovieDTO addMovie(MovieDTO movieDTO) {
        Movie movie = new Movie(movieDTO.getTitle(), movieDTO.getDirector(), movieDTO.getYear());
         if(movieRepository.existsMovieByTitle(movieDTO.getTitle())){
             throw new DuplicateFormatFlagsException("The title already exists");
         }
        return movieRepository.save(movie).viewAsMovieDTO();
    }

    @Override
    public MovieDTO updateMovie(Long id, MovieDTO movieDTO) {
        movieRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(ErrorMessages.ERROR_MOVIE_NOT_FOUND));
        Movie movie = new Movie(id,movieDTO.getTitle(), movieDTO.getDirector(), movieDTO.getYear());
        if(movieRepository.existsMovieByTitle(movieDTO.getTitle())){
            throw new DuplicateFormatFlagsException("The title already exists");
        }
        return movieRepository.save(movie).viewAsMovieDTO();
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(ErrorMessages.ERROR_MOVIE_NOT_FOUND));
        movieRepository.deleteById(id);

    }
}
