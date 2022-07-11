package com.danhuy.service;

import com.danhuy.dto.UserDTO;

public interface IUserService {

	UserDTO save(UserDTO dto);
	UserDTO findOneByEmailAndStatus(String email, Integer status);
	boolean existsByEmail(String email);
	boolean existsByUsername(String username);
}
