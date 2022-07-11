package com.danhuy.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.danhuy.constants.SystemConstants;
import com.danhuy.dto.MyUser;
import com.danhuy.entity.RoleEntity;
import com.danhuy.entity.UserEntity;
import com.danhuy.repository.UserRepository;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		final UserEntity user = userRepository.findOneByUsernameAndStatus(username, SystemConstants.STATUS_ACTIVE);
		if(user == null) { 
			throw new UsernameNotFoundException("User not found!");
		}
		Set<GrantedAuthority> authorities = new HashSet<>();
		for(RoleEntity role : user.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		MyUser myUser = new MyUser(user.getUsername(), user.getPassword(),
									true, true, true, true, authorities);
		myUser.setFullName(user.getFullName());
		return myUser;
	}

}
