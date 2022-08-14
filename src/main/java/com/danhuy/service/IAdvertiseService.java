package com.danhuy.service;

import java.util.List;
import java.util.Map;

import com.danhuy.dto.AdvertiseDTO;

public interface IAdvertiseService {

	List<AdvertiseDTO> findAll();
	List<AdvertiseDTO> findAllBySortDate();
	Map<Long, String> findAllForMap();
	AdvertiseDTO save(AdvertiseDTO dto);
}
