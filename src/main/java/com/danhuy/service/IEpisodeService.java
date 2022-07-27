package com.danhuy.service;

import java.util.List;

import com.danhuy.dto.EpisodeDTO;

public interface IEpisodeService {
	
	List<EpisodeDTO> findAllForList();
	EpisodeDTO save(EpisodeDTO dto);
}
