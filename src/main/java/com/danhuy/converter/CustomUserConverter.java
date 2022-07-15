package com.danhuy.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.danhuy.dto.UserDTO;
import com.danhuy.entity.RoleEntity;
import com.danhuy.entity.UserEntity;

@Component
public class CustomUserConverter {

	public UserDTO toDTO(UserDTO dto, UserEntity entity) {
		List<RoleEntity> roles = entity.getRoles();
		List<String> roleCode = new ArrayList<>();
		for(RoleEntity r : roles) {
			roleCode.add(r.getCode());
		}
		dto.setRoleCode(roleCode);
		return dto;
	}
	
	public UserEntity toEntity(UserEntity result, UserDTO dto) {
		result.setFullName(dto.getFullName());
		result.setEmail(dto.getEmail());
		result.setPhone(dto.getPhone());
		result.setAvatar(dto.getAvatar());
		return result;
	}
}
