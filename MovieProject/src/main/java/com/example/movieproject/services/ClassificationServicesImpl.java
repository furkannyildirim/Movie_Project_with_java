package com.example.movieproject.services;

import com.example.movieproject.dtos.ClassificationDTO;
import com.example.movieproject.exception.ErrorMessages;
import com.example.movieproject.exception.ResourceAlreadyExistsException;
import com.example.movieproject.model.Category;
import com.example.movieproject.model.Classification;
import com.example.movieproject.model.Movie;
import com.example.movieproject.repository.CategoryRepository;
import com.example.movieproject.repository.ClassificationRepository;
import com.example.movieproject.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.DuplicateFormatFlagsException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClassificationServicesImpl implements ClassificationServices {

    private final ClassificationRepository classificationRepository;
    private final MovieRepository movieRepository;
    private final CategoryRepository categoryRepository;

    public ClassificationServicesImpl(ClassificationRepository classificationRepository,MovieRepository movieRepository,CategoryRepository categoryRepository) {
        this.classificationRepository = classificationRepository;
        this.movieRepository = movieRepository;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<ClassificationDTO> getAllClassification() {
        return classificationRepository.findAll().stream().map(Classification::viewAsClassificationDTO).collect(Collectors.toList());
    }

    @Override
    public ClassificationDTO getClassificationById(Long id) {
        return classificationRepository.findById(id).orElseThrow(()->new RuntimeException(ErrorMessages.ERROR_CLASSIFICATION_NOT_FOUND)).viewAsClassificationDTO();
    }

    @Override
    public ClassificationDTO addClassification(ClassificationDTO classificationDTO) {
        Movie movie = movieRepository.findById(classificationDTO.getMovieDTO().getId()).orElseThrow(()->new ResourceAlreadyExistsException(ErrorMessages.ERROR_MOVIE_NOT_FOUND));
        Category category = categoryRepository.findById(classificationDTO.getCategoryDTO().getId()).orElseThrow(()->new ResourceAlreadyExistsException(ErrorMessages.ERROR_CATEGORY_NOT_FOUND));

        Classification classification = new Classification(classificationDTO.getClassificationDate(),movie,category);

        return classificationRepository.save(classification).viewAsClassificationDTO();
    }

    @Override
    public ClassificationDTO updateClassification(Long id, ClassificationDTO classificationDTO) {

        Movie movie = movieRepository.findById(classificationDTO.getMovieDTO().getId()).orElseThrow(()->new ResourceAlreadyExistsException(ErrorMessages.ERROR_MOVIE_NOT_FOUND));
        Category category = categoryRepository.findById(classificationDTO.getCategoryDTO().getId()).orElseThrow(()->new ResourceAlreadyExistsException(ErrorMessages.ERROR_CATEGORY_NOT_FOUND));
        Classification classification = new Classification(id,classificationDTO.getClassificationDate(),movie,category);
        return classificationRepository.save(classification).viewAsClassificationDTO();
    }

    @Override
    public void deleteClassification(Long id) {
        classificationRepository.findById(id).orElseThrow(()-> new ResourceAlreadyExistsException(ErrorMessages.ERROR_CLASSIFICATION_NOT_FOUND));
        classificationRepository.deleteById(id);
    }
}
