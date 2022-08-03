package com.danhuy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danhuy.converter.CustomEpisodeConverter;
import com.danhuy.dto.EpisodeDTO;
import com.danhuy.entity.EpisodeEntity;
import com.danhuy.entity.FilmEntity;
import com.danhuy.repository.EpisodeRepository;
import com.danhuy.repository.FilmRepository;
import com.danhuy.service.IEpisodeService;

@Service
public class EpisodeService implements IEpisodeService{

	@Autowired
	private EpisodeRepository episodeRepository;
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CustomEpisodeConverter converter;
	
	@Override
	public List<EpisodeDTO> findAllForList() {
		
		List<EpisodeDTO> results = new ArrayList<>();
		List<EpisodeEntity> entities = episodeRepository.findAll();
		for(EpisodeEntity e : entities) {
			EpisodeDTO dto = mapper.map(e, EpisodeDTO.class);
			// custom converter
			dto = converter.toDTO(dto, e);
			results.add(dto);
		}
		return results;
	}

	@Override
	public EpisodeDTO save(EpisodeDTO dto) {
		
		EpisodeEntity episodeEntity = new EpisodeEntity();
		Optional<FilmEntity> filmEntity = filmRepository.findById(Long.parseLong(dto.getFilmId()));
		
		episodeEntity = mapper.map(dto, EpisodeEntity.class);
		if(filmEntity.isPresent()) {
			episodeEntity.setFilm(filmEntity.get());
		}
		return mapper.map(episodeRepository.save(episodeEntity), EpisodeDTO.class);
	}

}
