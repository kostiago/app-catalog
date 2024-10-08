package com.kostiago.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kostiago.backend.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
