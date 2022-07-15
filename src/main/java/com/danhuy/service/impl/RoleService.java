package com.danhuy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhuy.dto.RoleDTO;
import com.danhuy.entity.RoleEntity;
import com.danhuy.repository.RoleRepository;
import com.danhuy.service.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public List<RoleDTO> findAll() {
		
		List<RoleDTO> results = new ArrayList<>();
		List<RoleEntity> entities = roleRepository.findAll();
		for(RoleEntity e : entities) {
			RoleDTO dto = mapper.map(e, RoleDTO.class);
			results.add(dto);
		}
		return results;
	}

	@Override
	public RoleDTO save(RoleDTO dto) {
		
		RoleEntity entity = mapper.map(dto, RoleEntity.class);
		return mapper.map(roleRepository.save(entity), RoleDTO.class);
	}

	@Override
	public boolean existsByCode(String code) {
		return roleRepository.existsByCode(code);
	}

	@Override
	public Map<String, String> findAllMap() {
		Map<String, String> results = new HashMap<>();
		List<RoleEntity> entities = roleRepository.findAll();
		for(RoleEntity e : entities) {
			results.put(e.getCode(), e.getName());
		}
		return results;
	}

}
