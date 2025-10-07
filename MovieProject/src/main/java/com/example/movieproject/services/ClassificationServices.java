package com.example.movieproject.services;

import com.example.movieproject.dtos.ClassificationDTO;

import java.util.List;

public interface ClassificationServices {
    List<ClassificationDTO> getAllClassification();
    ClassificationDTO getClassificationById(Long id);
    ClassificationDTO addClassification(ClassificationDTO movie);
    ClassificationDTO updateClassification(Long id, ClassificationDTO movieDetails);
    void deleteClassification(Long id);

}
