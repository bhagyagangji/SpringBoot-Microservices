package com.wipro.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wipro.product.exceptions.ProductNotFoundException;
import com.wipro.product.repository.ProductRepository;
import com.wipro.product.request.dto.Product;

@Service
public class ProductServiceImpl implements ProductService{
	private ProductRepository repository;
	public ProductServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}
	@Override
	public Product save(Product product) {
		return repository.save(product);
	}
	@Override
	public Optional<Product> findById(int id) throws ProductNotFoundException {
		return repository.findById(id);
	}
	@Override
	public List<Product> findAll() {
		return repository.findAll();
	}
	@Override
	public Optional<Product> findByName(String name) throws ProductNotFoundException {
		return repository.findByName(name);
	}
}
