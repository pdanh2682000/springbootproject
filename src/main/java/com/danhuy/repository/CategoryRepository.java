package com.danhuy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danhuy.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
	
	CategoryEntity findOneByCode(String code);
}
