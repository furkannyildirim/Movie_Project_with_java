package com.example.movieproject.controller;

import com.example.movieproject.dtos.CategoryDTO;
import com.example.movieproject.services.CategoryServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryServices categoryServices;
    public CategoryController(CategoryServices categoryServices) {
        this.categoryServices = categoryServices;
    }

    @PostMapping("/add")
    public ResponseEntity<CategoryDTO> addCategory(@RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryServices.addCategory(categoryDTO), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable long id) {
        return new ResponseEntity<>(categoryServices.getCategoryById(id), HttpStatus.OK);
    }

    @GetMapping("/get/all")
    public ResponseEntity<List<CategoryDTO>> getAllCategory() {
        return new ResponseEntity<>(categoryServices.getAllCategory(), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable long id, @RequestBody CategoryDTO categoryDTO) {
        return new ResponseEntity<>(categoryServices.updateCategory(id, categoryDTO), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable long id) {
        categoryServices.deleteCategory(id);
        return new ResponseEntity<>("Deleted operation is successfully",HttpStatus.OK);
    }

}