package com.example.movieproject.repository;

import com.example.movieproject.model.Movie;
import com.example.movieproject.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    boolean existsMovieByTitle(String title);
}
