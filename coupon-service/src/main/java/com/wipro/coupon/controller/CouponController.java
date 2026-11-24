package com.wipro.coupon.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.coupon.exceptions.CouponNotFoundException;
import com.wipro.coupon.request.dto.Coupon;
import com.wipro.coupon.service.CouponService;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Coupon Controller", description = "Manages the Coupons")
@RequestMapping("api/coupons")
@RestController
public class CouponController {
	private CouponService service;
	public CouponController(CouponService service) {
		this.service = service;
	}
	
	@PostMapping
	ResponseEntity<Coupon> save(@RequestBody Coupon coupon){
		Coupon c = service.save(coupon);
		System.out.println(coupon.getCode());
		System.out.println(c.getCode());
		return new ResponseEntity<Coupon>(c,HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Coupon> findById(@PathVariable int id){
		Optional<Coupon> product = service.findById(id);
		if(product.isPresent())
			return new ResponseEntity<Coupon>(product.get(),HttpStatus.OK);
		else 
			throw new CouponNotFoundException("Coupon not found with id : " + id);
	}
	
	@GetMapping
	ResponseEntity<List<Coupon>> findAll() {
		return new ResponseEntity<List<Coupon>>(service.findAll(),HttpStatus.OK);
	}
	
	@GetMapping("/code/{code}")
	ResponseEntity<Coupon> findByCode(@PathVariable String code) {
		Optional<Coupon> coupon = service.findByCode(code);
		if(coupon.isPresent())
			return new ResponseEntity<Coupon>(coupon.get(),HttpStatus.OK);
		else 
			throw new CouponNotFoundException("Coupon not found with code : " + code);
	}
}
