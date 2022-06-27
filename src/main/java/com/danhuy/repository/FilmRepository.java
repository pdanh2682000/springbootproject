package com.danhuy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.danhuy.entity.FilmEntity;

public interface FilmRepository extends JpaRepository<FilmEntity, Long> {
	
	List<FilmEntity> findAllByPosterSlide(int posterSlide);
	
}
