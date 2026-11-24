package com.wipro.product.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.coupon.request.dto.Coupon;

@FeignClient(
		name = "COUPON-SERVICE",
		path = "/api/coupons"
)
public interface CouponClient {
	@GetMapping("/code/{code}")
	Optional<Coupon> findByCode(@PathVariable("code") String code);
}
