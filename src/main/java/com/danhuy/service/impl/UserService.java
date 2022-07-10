package com.danhuy.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.danhuy.dto.UserDTO;
import com.danhuy.entity.UserEntity;
import com.danhuy.repository.UserRepository;
import com.danhuy.service.IUserService;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDTO save(UserDTO dto) {
		
		UserEntity userEntity = new UserEntity();
		userEntity = mapper.map(dto, UserEntity.class);
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
		userEntity.setStatus(1);
		return mapper.map(userRepository.save(userEntity), UserDTO.class);
	}

	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username);
	}

}
