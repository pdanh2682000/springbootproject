package com.danhuy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.danhuy.constants.SystemConstants;
import com.danhuy.converter.CustomUserConverter;
import com.danhuy.dto.UserDTO;
import com.danhuy.entity.RoleEntity;
import com.danhuy.entity.UserEntity;
import com.danhuy.repository.RoleRepository;
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
	
	@Autowired
	private CustomUserConverter converter;
	
	@Autowired
	private RoleRepository RoleRepository;
	
	@Override
	public UserDTO save(UserDTO dto) {
		
		UserEntity userEntity = new UserEntity();
		// update
		if(dto.getId() != null) {
			Optional<UserEntity> oldUserEntity = userRepository.findById(dto.getId());
			if(oldUserEntity.isPresent()) {
				if(!dto.getPassword().equals(oldUserEntity.get().getPassword())){ // update new password
					oldUserEntity.get().setPassword(passwordEncoder.encode(dto.getPassword()));
				}
				if(dto.getAvatar() == null || dto.getAvatar().isEmpty())
					dto.setAvatar(oldUserEntity.get().getAvatar()); // set default url from old
				userEntity = converter.toEntity(oldUserEntity.get(), dto);
			}
		}
		// create
		else {
			userEntity = mapper.map(dto, UserEntity.class);
			userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
			userEntity.setStatus(SystemConstants.STATUS_ACTIVE);
		}
		// set roles
		List<RoleEntity> results = new ArrayList<>();
		if(dto.getRoleCode() != null) {
			for(String code : dto.getRoleCode()) {
				RoleEntity entity = RoleRepository.findByCode(code);
				results.add(entity);
			}
		}
		// for signup
		else {
			RoleEntity entity = RoleRepository.findByCode(SystemConstants.DEFAULT_ROLE);
			results.add(entity);
		}
		userEntity.setRoles(results);
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

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> results = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll();
		for(UserEntity e : entities) {
			UserDTO dto = mapper.map(e, UserDTO.class);
			// custom converter
			dto = converter.toDTO(dto, e);
			results.add(dto);
		}
		return results;
	}

	@Override
	public List<UserDTO> findAll(Pageable pageable) {
		List<UserDTO> results = new ArrayList<>();
		List<UserEntity> entities = userRepository.findAll(pageable).getContent();
		for(UserEntity e : entities) {
			UserDTO dto = mapper.map(e, UserDTO.class);
			// custom converter
			dto = converter.toDTO(dto, e);
			results.add(dto);
		}
		return results;
	}

	@Override
	public long getTotalItem() {
		return userRepository.count();
	}

	@Override
	public UserDTO findById(Long id) {
		Optional<UserEntity> userEntity = userRepository.findById(id);
		if(userEntity.isPresent()) {
			UserDTO dto = mapper.map(userEntity.get(), UserDTO.class);
			// custom converter;
			dto = converter.toDTO(dto, userEntity.get());
			return dto;
		}
		return null;
	}

}
