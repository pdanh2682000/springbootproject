package com.danhuy.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.danhuy.entity.UserCommentFilmEntity;

public interface UserCommentFilmRepository extends JpaRepository<UserCommentFilmEntity, Long> {

	List<UserCommentFilmEntity> findAllByFilmId(Long filmId);
	List<UserCommentFilmEntity> findAllByFilmId(Long filmId, Pageable pageable);
	long countByFilmId(Long filmId);
}
