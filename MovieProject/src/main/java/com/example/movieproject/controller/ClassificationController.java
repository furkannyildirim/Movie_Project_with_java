package com.example.movieproject.controller;

import com.example.movieproject.dtos.CategoryDTO;
import com.example.movieproject.dtos.ClassificationDTO;
import com.example.movieproject.model.Classification;
import com.example.movieproject.services.CategoryServices;
import com.example.movieproject.services.ClassificationServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classification")
public class ClassificationController {
    private final ClassificationServices classificationServices;
    public ClassificationController(ClassificationServices classificationServices) {
        this.classificationServices = classificationServices;
    }

    @PostMapping("/add")
    public ResponseEntity<ClassificationDTO> addClassification(@RequestBody ClassificationDTO classificationDTO) {
        return new ResponseEntity<>(classificationServices.addClassification(classificationDTO), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ClassificationDTO> getClassification(@PathVariable long id) {
        return new ResponseEntity<>(classificationServices.getClassificationById(id), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<ClassificationDTO>> getAllClassifications() {
        return new ResponseEntity<>(classificationServices.getAllClassification(), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<ClassificationDTO> updateCategory(@PathVariable long id, @RequestBody ClassificationDTO classificationDTO) {
        return new ResponseEntity<>(classificationServices.updateClassification(id, classificationDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable long id) {
        classificationServices.deleteClassification(id);
        return new ResponseEntity<>("Deleted operation is successfully",HttpStatus.OK);
    }
}
