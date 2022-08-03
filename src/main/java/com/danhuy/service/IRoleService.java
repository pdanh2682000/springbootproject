package com.danhuy.service;

import java.util.List;
import java.util.Map;

import com.danhuy.dto.RoleDTO;

public interface IRoleService {

	List<RoleDTO> findAll();
	Map<String, String> findAllMap();
	RoleDTO save(RoleDTO dto);
	boolean existsByCode(String code);
}
