package com.wipro.coupon.service;

import java.util.List;
import java.util.Optional;

import com.wipro.coupon.exceptions.CouponNotFoundException;
import com.wipro.coupon.request.dto.Coupon;

public interface CouponService {
	Coupon save(Coupon coupon);
	Optional<Coupon> findById(int id) throws CouponNotFoundException;
	List<Coupon> findAll();
	Optional<Coupon> findByCode(String code) throws CouponNotFoundException;
}
