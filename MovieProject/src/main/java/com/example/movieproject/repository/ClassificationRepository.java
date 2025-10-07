package com.example.movieproject.repository;

import com.example.movieproject.model.Classification;
import com.example.movieproject.model.Classification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificationRepository extends JpaRepository<Classification, Long> {


}
