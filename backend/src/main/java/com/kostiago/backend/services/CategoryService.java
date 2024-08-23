package com.kostiago.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kostiago.backend.entities.Category;
import com.kostiago.backend.repositories.CategoryRepository;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }
}
