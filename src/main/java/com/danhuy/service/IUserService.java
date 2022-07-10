package com.danhuy.service;

import com.danhuy.dto.UserDTO;

public interface IUserService {

	UserDTO save(UserDTO dto);
	boolean existsByEmail(String email);
	boolean existsByUsername(String username);
}
