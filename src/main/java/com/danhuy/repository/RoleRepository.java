package com.danhuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danhuy.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {

	boolean existsByCode(String code);
	RoleEntity findByCode(String code);
}
