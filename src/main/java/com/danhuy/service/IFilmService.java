package com.danhuy.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;

import com.danhuy.dto.FilmDTO;

public interface IFilmService {
	
	List<FilmDTO> findAll();
	List<FilmDTO> findAllByPosterSlide(int status);
	List<FilmDTO> findAll(Pageable pageable);
	List<FilmDTO> findAllByTitle(String title);
	List<FilmDTO> findAllByActor(String actor);
	Map<String, String> findAllName();
	long getTotalItem();
	FilmDTO save(FilmDTO dto);
	FilmDTO findById(Long id);
	void delete(long[] ids);
	void addFilmRate(String filmId, String starNum);
	long countQuantityFilmRate(String filmId);
}
