package com.example.movieproject.model;

import com.example.movieproject.dtos.CategoryDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 64, nullable = false)
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Classification> classifications;

    public CategoryDTO viewAsCategoryDTO(){
        return new CategoryDTO(this.id,this.name);
    }
    public Category(String name){
        this.name = name;
    }
    public Category(){}

    public Category(long id, String name){
        this.id = id;
        this.name = name;
    }
}
