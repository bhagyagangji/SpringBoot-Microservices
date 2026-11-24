package com.wipro.coupon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wipro.coupon.exceptions.CouponNotFoundException;
import com.wipro.coupon.repository.CouponRepository;
import com.wipro.coupon.request.dto.Coupon;

@Service
public class CouponServiceImpl implements CouponService{
	private final CouponRepository repository;

	CouponServiceImpl(CouponRepository repository) {
		this.repository = repository;
	}

	@Override
	public Coupon save(Coupon coupon) {
		return repository.save(coupon);
	}

	@Override
	public Optional<Coupon> findById(int id) throws CouponNotFoundException{
		return repository.findById(id);
	}

	@Override
	public List<Coupon> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Coupon> findByCode(String code) throws CouponNotFoundException{
		return repository.findByCode(code);
	}
	
	
	
}
