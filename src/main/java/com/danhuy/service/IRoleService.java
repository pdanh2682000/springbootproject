package com.danhuy.service;

import java.util.List;

import com.danhuy.dto.RoleDTO;

public interface IRoleService {

	List<RoleDTO> findAll();
	RoleDTO save(RoleDTO dto);
	boolean existsByCode(String code);
}
