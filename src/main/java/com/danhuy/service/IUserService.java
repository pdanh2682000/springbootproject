package com.danhuy.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.danhuy.dto.UserDTO;

public interface IUserService {

	List<UserDTO> findAll();
	List<UserDTO> findAll(Pageable pageable);
	UserDTO save(UserDTO dto);
	UserDTO findOneByEmailAndStatus(String email, Integer status);
	UserDTO findById(Long id);
	long getTotalItem();
	boolean existsByEmail(String email);
	boolean existsByUsername(String username);
}
