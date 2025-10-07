package com.example.movieproject.dtos;

import java.time.LocalDateTime;

public class ClassificationDTO {
    private long id;
    private LocalDateTime classificationDate;
    private MovieDTO movieDTO;
    private CategoryDTO categoryDTO;
    public ClassificationDTO() {}
    public ClassificationDTO(long id, LocalDateTime classificationDate, MovieDTO movieDTO, CategoryDTO categoryDTO) {
        this.id = id;
        this.classificationDate = classificationDate;
        this.movieDTO = movieDTO;
        this.categoryDTO = categoryDTO;
    }

    public ClassificationDTO(LocalDateTime classificationDate, MovieDTO movieDTO, CategoryDTO categoryDTO) {
        this.classificationDate = classificationDate;
        this.movieDTO = movieDTO;
        this.categoryDTO = categoryDTO;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getClassificationDate() {
        return classificationDate;
    }

    public void setClassificationDate(LocalDateTime classificationDate) {
        this.classificationDate = classificationDate;
    }

    public MovieDTO getMovieDTO() {
        return movieDTO;
    }

    public void setMovieDTO(MovieDTO movieDTO) {
        this.movieDTO = movieDTO;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
