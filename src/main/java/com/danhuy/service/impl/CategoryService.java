package com.danhuy.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.danhuy.dto.CategoryDTO;
import com.danhuy.entity.CategoryEntity;
import com.danhuy.repository.CategoryRepository;
import com.danhuy.service.ICategoryService;

@Service
public class CategoryService implements ICategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Map<String, String> findAll() {
		
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for(CategoryEntity e : entities) {
			result.put(e.getCode(), e.getName());
		}
		return result;
	}

	@Override
	public List<CategoryDTO> findAllForList() {
		
		List<CategoryDTO> results = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for(CategoryEntity e : entities) {
			CategoryDTO dto = mapper.map(e, CategoryDTO.class);
			results.add(dto);
		}
		return results;
	}

	@Override
	public List<CategoryDTO> findAllForPaging(Pageable pageable) {
		
		List<CategoryDTO> results = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll(pageable).getContent();
		for(CategoryEntity e : entities) {
			CategoryDTO dto = mapper.map(e, CategoryDTO.class);
			results.add(dto);
		}
		return results;
	}

	@Override
	public CategoryDTO save(CategoryDTO dto) {
		
		CategoryEntity entity = mapper.map(dto, CategoryEntity.class);
		return mapper.map(categoryRepository.save(entity), CategoryDTO.class);
	}

	@Override
	public boolean existsByCode(String code) {
		return categoryRepository.existsByCode(code);
	}

}
