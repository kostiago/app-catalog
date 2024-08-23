package com.kostiago.backend.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kostiago.backend.dto.CategoryDTO;

import com.kostiago.backend.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
    
    @Autowired
    private CategoryService service;
    /**
     * Metodo para retornar todas as categorias
     * @return retorna todas as categorias se tiver
     */
    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll (){

        List<CategoryDTO> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    /**
     * Metodo para retornar uma categoria pelo id.
     * @param id utilizado para fazer a consulta
     * @return retorna uma categoria especifica pelo id
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDTO> findById (@PathVariable Long id){

        CategoryDTO dto = service.findById (id);
        return ResponseEntity.ok().body(dto);
    }
}
