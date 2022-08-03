package com.danhuy.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.danhuy.dto.AdvertiseDTO;
import com.danhuy.dto.FilmDTO;
import com.danhuy.entity.AdvertiseEntity;
import com.danhuy.entity.FilmEntity;

@Component
public class CustomAdvertiseConverter {

	public AdvertiseDTO toDTO(AdvertiseDTO dto, AdvertiseEntity entity) {
		Set<FilmDTO> listFilmDTO = new HashSet<>();
		if(entity.getFilms() != null) {
			for(FilmEntity e : entity.getFilms()) {
				FilmDTO dtoFilm = new FilmDTO();
				dtoFilm.setId(e.getId());
				dtoFilm.setTitle(e.getTitle());
				dtoFilm.setPremiereDate(e.getPremiereDate());
				listFilmDTO.add(dtoFilm);
			}
		}
		dto.setFilms(listFilmDTO);
		return dto;
	}
}
