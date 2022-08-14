package com.danhuy.utils;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.danhuy.dto.MyUser;

public class SecurityUtils {

	public static MyUser getPrincipal() {
		try {
			return (MyUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch(Exception e) {
			Set<GrantedAuthority> authorities = new HashSet<>();
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
			MyUser user = new MyUser("Google account", "none",
					true, true, true, true, authorities);
			return user;
		}
	}
}
