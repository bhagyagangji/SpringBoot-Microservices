package com.wipro.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.product.request.dto.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	Optional<Product> findByName(String name);
}
