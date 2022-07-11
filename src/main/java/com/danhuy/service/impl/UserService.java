package com.danhuy.service.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.danhuy.constants.SystemConstants;
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
		if(dto.getId() != null) {
			Optional<UserEntity> oldUserEntity = userRepository.findById(dto.getId());
			if(oldUserEntity.isPresent()) {
				oldUserEntity.get().setPassword(passwordEncoder.encode(dto.getPassword()));
			}
			return mapper.map(userRepository.save(oldUserEntity.get()), UserDTO.class);
		}
		else {
			userEntity = mapper.map(dto, UserEntity.class);
			userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
			userEntity.setStatus(SystemConstants.STATUS_ACTIVE);
		}
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

	@Override
	public UserDTO findOneByEmailAndStatus(String email, Integer status) {
		UserEntity entity = userRepository.findOneByEmailAndStatus(email, status);
		if(entity != null) {
			return mapper.map(entity, UserDTO.class);
		}
		return null;
	}

}
