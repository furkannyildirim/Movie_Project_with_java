package com.example.movieproject.services;

import com.example.movieproject.dtos.CategoryDTO;
import com.example.movieproject.dtos.CategoryDTO;
import com.example.movieproject.exception.ErrorMessages;
import com.example.movieproject.exception.ResourceAlreadyExistsException;
import com.example.movieproject.exception.ResourceNotFoundException;
import com.example.movieproject.model.Category;
import com.example.movieproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.DuplicateFormatFlagsException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServicesImpl implements CategoryServices {
    private final CategoryRepository categoryRepository;

    public CategoryServicesImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<CategoryDTO> getAllCategory() {
        return categoryRepository.findAll().stream().map(Category::viewAsCategoryDTO).collect(Collectors.toList());

    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return categoryRepository.findById(id).orElseThrow(()->new ResourceAlreadyExistsException(ErrorMessages.ERROR_CATEGORY_NOT_FOUND)).viewAsCategoryDTO();
    }

    @Override
    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = new Category(categoryDTO.getName());
        if(categoryRepository.existsCategoryByName(categoryDTO.getName())){
            throw new DuplicateFormatFlagsException("The name already exists");
        }
        return categoryRepository.save(category).viewAsCategoryDTO();
    }

    @Override
    public CategoryDTO updateCategory(Long id, CategoryDTO categoryDTO) {
        categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(ErrorMessages.ERROR_CATEGORY_NOT_FOUND));
        Category category = new Category(id,categoryDTO.getName());
        if(categoryRepository.existsCategoryByName(categoryDTO.getName())){
            throw new DuplicateFormatFlagsException("The name already exists");
        }
        return categoryRepository.save(category).viewAsCategoryDTO();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.findById(id).orElseThrow(()->new ResourceNotFoundException(ErrorMessages.ERROR_CATEGORY_NOT_FOUND));
        categoryRepository.deleteById(id);

    }
}
