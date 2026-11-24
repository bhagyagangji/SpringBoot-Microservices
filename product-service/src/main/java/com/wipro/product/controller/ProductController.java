package com.wipro.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.coupon.request.dto.Coupon;
import com.wipro.product.client.CouponClient;
import com.wipro.product.exceptions.ProductNotFoundException;
import com.wipro.product.request.dto.Product;
import com.wipro.product.response.dto.ErrorMessage;
import com.wipro.product.service.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Product Controller", description = "Manages the Products")
@RequestMapping("api/products")
@RestController
public class ProductController {
	private final ProductService service;
	private final CouponClient client;

	ProductController(ProductService service, CouponClient client) {
		this.service = service;
		this.client = client;
	}
	
	@Operation(summary = "save a product")
	@PostMapping
	ResponseEntity<Product> save(@RequestBody Product product){
		return new ResponseEntity<Product>(service.save(product),HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Product> findById(@PathVariable int id){
		Optional<Product> product = service.findById(id);
		if(product.isPresent())
			return new ResponseEntity<Product>(product.get(),HttpStatus.OK);
		else 
			throw new ProductNotFoundException("Product not found with id : " + id);
	}
	
	@GetMapping
	ResponseEntity<List<Product>> findAll() {
		return new ResponseEntity<List<Product>>(service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	ResponseEntity<Product> findByName(@PathVariable String name) {
		Optional<Product> product = service.findByName(name);
		if(product.isPresent())
			return new ResponseEntity<Product>(product.get(),HttpStatus.OK);
		else 
			throw new ProductNotFoundException("Product not found with id : " + name);
	}
	
	@GetMapping("/{name}/{code}") ResponseEntity<Product> findByCouponCode(@PathVariable String name,
			@PathVariable String code){
		Optional<Product> product = service.findByName(name);
		if(product.isPresent()) {
			Product p = product.get();
			Coupon coupon = client.findByCode(code).get();
			p.setPrice(p.getPrice()-coupon.getDiscount());
			return new ResponseEntity<Product>(p,HttpStatus.OK);
		}
		else {
			throw new ProductNotFoundException("Product not Found with name : " + name);
		}
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	ResponseEntity<ErrorMessage> handleProductNotFoundException(ProductNotFoundException exception) {
		ErrorMessage res = new ErrorMessage();
		res.setMessage(exception.getMessage());
		res.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity<ErrorMessage>(res,HttpStatus.NOT_FOUND);
	}
}
