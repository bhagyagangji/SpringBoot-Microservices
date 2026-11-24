package com.wipro.product.service;

import java.util.List;
import java.util.Optional;

import com.wipro.product.exceptions.ProductNotFoundException;
import com.wipro.product.request.dto.Product;

public interface ProductService {
	Product save(Product product);
	Optional<Product> findById(int id) throws ProductNotFoundException;
	List<Product> findAll();
	Optional<Product> findByName(String name) throws ProductNotFoundException;
}
