package com.danhuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danhuy.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findOneByUsernameAndStatus(String name, Integer status);
	UserEntity findOneByEmailAndStatus(String email, Integer status);
	boolean existsByEmail(String email);
	boolean existsByUsername(String username);
}
