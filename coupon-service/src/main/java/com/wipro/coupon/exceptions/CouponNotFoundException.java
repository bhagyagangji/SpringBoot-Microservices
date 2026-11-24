package com.wipro.coupon.exceptions;

public class CouponNotFoundException extends RuntimeException {
	public CouponNotFoundException(String message) {
		super(message);
	}
}
