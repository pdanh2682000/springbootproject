package com.danhuy.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.danhuy.dto.UserCommentFilmDTO;
import com.danhuy.request.PostCommentRequest;

public interface IUserCommentFilmService {

	void save(PostCommentRequest request);
	List<UserCommentFilmDTO> findAll();
	List<UserCommentFilmDTO> findAllByFilmId(String filmId);
	List<UserCommentFilmDTO> findAllByFilmId(String filmId, Pageable pagable);
	long countByFilmId(String filmId);
}
