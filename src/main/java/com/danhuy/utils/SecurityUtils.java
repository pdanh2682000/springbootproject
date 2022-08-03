package com.danhuy.utils;

import org.springframework.security.core.context.SecurityContextHolder;

import com.danhuy.dto.MyUser;

public class SecurityUtils {

	public static MyUser getPrincipal() {
		return (MyUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}
}
