package com.wipro.coupon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.coupon.request.dto.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer>{
	Optional<Coupon> findByCode(String code);
}
