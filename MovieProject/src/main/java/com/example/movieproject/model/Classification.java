package com.example.movieproject.model;

import com.example.movieproject.dtos.CategoryDTO;
import com.example.movieproject.dtos.ClassificationDTO;
import com.example.movieproject.dtos.MovieDTO;
import com.example.movieproject.repository.MovieRepository;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Classification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "classification_date")
    private LocalDateTime classificationDate;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public ClassificationDTO viewAsClassificationDTO() {
        MovieDTO movieDTO = movie.viewAsMovieDTO();
        CategoryDTO categoryDTO = category.viewAsCategoryDTO();
        return new ClassificationDTO(this.id,this.classificationDate,movieDTO,categoryDTO);
    }

    public Classification(long id, LocalDateTime classificationDate, Movie movie, Category category) {
        this.id = id;
        this.classificationDate = classificationDate;
        this.movie = movie;
        this.category = category;
    }

    public Classification(LocalDateTime classificationDate, Movie movie, Category category) {
        this.classificationDate = classificationDate;
        this.movie = movie;
        this.category = category;
    }
    public Classification() {}
}
