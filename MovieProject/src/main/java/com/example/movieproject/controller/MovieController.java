package com.example.movieproject.controller;

import com.example.movieproject.dtos.MovieDTO;
import com.example.movieproject.model.Movie;
import com.example.movieproject.services.MovieServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    private final MovieServices movieServices;
    public MovieController(MovieServices movieServices) {
        this.movieServices = movieServices;
    }

    @PostMapping("/add")
    public ResponseEntity<MovieDTO> addMovie(@RequestBody MovieDTO movieDTO) {
        return new ResponseEntity<>(movieServices.addMovie(movieDTO), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable long id) {
        return new ResponseEntity<>(movieServices.getMovieById(id), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        return new ResponseEntity<>(movieServices.getAllMovies(), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable long id, @RequestBody MovieDTO movieDTO) {
        return new ResponseEntity<>(movieServices.updateMovie(id, movieDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable long id) {
        movieServices.deleteMovie(id);
        return new ResponseEntity<>("Deleted operation is successfully",HttpStatus.OK);
    }

}
