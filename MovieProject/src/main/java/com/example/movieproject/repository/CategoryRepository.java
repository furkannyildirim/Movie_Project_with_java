package com.example.movieproject.repository;

import com.example.movieproject.model.Category;
import com.example.movieproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    boolean existsCategoryByName(String name);
}
