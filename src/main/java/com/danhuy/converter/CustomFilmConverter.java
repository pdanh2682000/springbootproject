package com.danhuy.converter;

import org.springframework.stereotype.Component;

import com.danhuy.dto.FilmDTO;
import com.danhuy.entity.FilmEntity;

@Component
public class CustomFilmConverter {
	
	public FilmDTO toDTO(FilmDTO dto, FilmEntity entity) {
		dto.setCategoryId(entity.getCategory().getId());
		dto.setCategoryCode(entity.getCategory().getCode());
		dto.setCategoryName(entity.getCategory().getName());
		return dto;
	}
	
	public FilmEntity toEntity(FilmEntity result, FilmDTO dto) {
		result.setActor(dto.getActor());
		result.setAuthor(dto.getAuthor());
		result.setContent(dto.getContent());
		result.setFilmLength(dto.getFilmLength());
		result.setPublishDate(dto.getPublishDate());
		result.setShortDescription(dto.getShortDescription());
		result.setTitle(dto.getTitle());
		result.setUrl(dto.getUrl());
		return result;
	}
}
