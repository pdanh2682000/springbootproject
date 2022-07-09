package com.danhuy.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.danhuy.dto.CategoryDTO;

public interface ICategoryService {
	
	Map<String, String> findAll();
	List<CategoryDTO> findAllForList();
	List<CategoryDTO> findAllForPaging(Pageable pageable);
	CategoryDTO save(CategoryDTO dto);
}
