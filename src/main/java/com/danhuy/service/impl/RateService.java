package com.danhuy.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhuy.dto.RateDTO;
import com.danhuy.entity.RateEntity;
import com.danhuy.repository.RateRepository;
import com.danhuy.service.IRateService;

@Service
public class RateService implements IRateService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private RateRepository rateRepository;
	
	@Override
	public List<RateDTO> findAll() {
		
		List<RateDTO> results = new ArrayList<>();
		List<RateEntity> entities = rateRepository.findAll();
		for(RateEntity e : entities) {
			RateDTO dto = new RateDTO();
			dto = mapper.map(e, RateDTO.class);
			results.add(dto);
		}
		return results;
	}

}
