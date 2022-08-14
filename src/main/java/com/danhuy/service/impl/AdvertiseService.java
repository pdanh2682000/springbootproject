package com.danhuy.service.impl;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhuy.converter.CustomAdvertiseConverter;
import com.danhuy.dto.AdvertiseDTO;
import com.danhuy.entity.AdvertiseEntity;
import com.danhuy.repository.AdvertiseRepository;
import com.danhuy.service.IAdvertiseService;

@Service
public class AdvertiseService implements IAdvertiseService {

	@Autowired
	private AdvertiseRepository advertiseRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CustomAdvertiseConverter converter;
	
	@Override
	public List<AdvertiseDTO> findAll() {
		
		// code new avoid loop
		return advertiseRepository.findAll().stream()
				.map(entity -> converter.toDTO(mapper.map(entity, AdvertiseDTO.class), entity))
				.collect(Collectors.toList());
	}

	@Override
	public Map<Long, String> findAllForMap() {
		return advertiseRepository.findAll().stream().collect(Collectors.toMap(AdvertiseEntity::getId, AdvertiseEntity::getTitleAdvertise));
	}

	@Override
	public AdvertiseDTO save(AdvertiseDTO dto) {
		
		AdvertiseEntity entity = mapper.map(dto, AdvertiseEntity.class);
		return mapper.map(advertiseRepository.save(entity), AdvertiseDTO.class);
	}

	@Override
	public List<AdvertiseDTO> findAllBySortDate() {
		// TODO Auto-generated method stub
		return null;
	}


}
