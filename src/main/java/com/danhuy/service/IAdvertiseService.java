package com.danhuy.service;

import java.util.List;
import java.util.Map;

import com.danhuy.dto.AdvertiseDTO;

public interface IAdvertiseService {

	List<AdvertiseDTO> findAll();
	Map<Long, String> findAllForMap();
}
