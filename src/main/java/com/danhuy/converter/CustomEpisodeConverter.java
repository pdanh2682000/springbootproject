package com.danhuy.converter;

import org.springframework.stereotype.Component;

import com.danhuy.dto.EpisodeDTO;
import com.danhuy.entity.EpisodeEntity;

@Component
public class CustomEpisodeConverter {

	public EpisodeDTO toDTO(EpisodeDTO dto, EpisodeEntity entity) {
		if(entity.getFilm() != null) {
			dto.setFilmId(entity.getFilm().getId().toString());
			dto.setFilmName(entity.getFilm().getTitle());
		}
		return dto;
	}
}
