package com.kostiago.backend.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kostiago.backend.entities.Category;

@RestController
@RequestMapping(value = "categories")
public class CategoryResource {
    
    /**
     * Metodo para retornar todas as categorias
     * @return retorna todas as categorias se tiver
     */
    @GetMapping
    public ResponseEntity<List<Category>> findAll (){

        List<Category> category = new ArrayList<>();
        category.add(new Category(1L, "Livros"));
        category.add(new Category(2L, "Eletronicos"));

        return ResponseEntity.ok().body(category);
    }
}
