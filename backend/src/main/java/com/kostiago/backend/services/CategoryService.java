package com.kostiago.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kostiago.backend.dto.CategoryDTO;
import com.kostiago.backend.entities.Category;
import com.kostiago.backend.repositories.CategoryRepository;
import com.kostiago.backend.services.exceptions.DatabaseException;
import com.kostiago.backend.services.exceptions.ResourceNotFoundExeception;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAllPaged(PageRequest pageRequest) {

        Page<Category> category = repository.findAll(pageRequest);
        return category.map(cat -> new CategoryDTO(cat));
    }

    public CategoryDTO findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(() -> new ResourceNotFoundExeception("Entity not found"));
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO insertCategory(CategoryDTO dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        entity = repository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO updateCategory(Long id, CategoryDTO dto) {
        try {
            Category entity = repository.getReferenceById(id);
            entity.setName(dto.getName());
            entity = repository.save(entity);
            return new CategoryDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundExeception("Id not found" + id);
        }
    }

    public void deleteCategory(Long id) {

        // Verifica se o produto existe
        Optional<Category> category = repository.findById(id);

        // Exception, caso o produto não exista
        if (category.isEmpty()) {
            throw new ResourceNotFoundExeception(
                    "Não foi possivel encontrar a categoria com id: " + id);
        }

        // Deleta o produto pelo id
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Violação de integridade: " + e.getMessage());
        }
    }

}
