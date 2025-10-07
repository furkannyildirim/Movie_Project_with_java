package com.example.movieproject.services;

import com.example.movieproject.dtos.CategoryDTO;

import java.util.List;

public interface CategoryServices {
    List<CategoryDTO> getAllCategory();
    CategoryDTO getCategoryById(Long id);
    CategoryDTO addCategory(CategoryDTO category);
    CategoryDTO updateCategory(Long id, CategoryDTO categoryDetails);
    void deleteCategory(Long id);
}
