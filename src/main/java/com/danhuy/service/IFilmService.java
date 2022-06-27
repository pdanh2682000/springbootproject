package com.danhuy.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.danhuy.dto.FilmDTO;

public interface IFilmService {
	
	List<FilmDTO> findAll();
	List<FilmDTO> findAllByPosterSlide(int status);
	List<FilmDTO> findAll(Pageable pageable);
	long getTotalItem();
	FilmDTO save(FilmDTO dto);
	FilmDTO findById(Long id);
}
