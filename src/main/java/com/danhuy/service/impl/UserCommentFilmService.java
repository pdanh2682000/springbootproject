package com.danhuy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.danhuy.converter.CustomCommentConverter;
import com.danhuy.dto.UserCommentFilmDTO;
import com.danhuy.entity.FilmEntity;
import com.danhuy.entity.UserCommentFilmEntity;
import com.danhuy.entity.UserEntity;
import com.danhuy.repository.FilmRepository;
import com.danhuy.repository.UserCommentFilmRepository;
import com.danhuy.repository.UserRepository;
import com.danhuy.request.PostCommentRequest;
import com.danhuy.service.IUserCommentFilmService;

@Service
public class UserCommentFilmService implements IUserCommentFilmService {

	@Autowired
	private UserCommentFilmRepository userCommentFilmRepository;
	
	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private CustomCommentConverter converter;
	
	@Override
	public void save(PostCommentRequest request) {
		
		UserCommentFilmEntity entity = new UserCommentFilmEntity();
		Optional<FilmEntity> filmEntity = Optional.ofNullable(new FilmEntity());
		Optional<UserEntity> userEntity = Optional.ofNullable(new UserEntity());
		if(!request.getFilmId().isEmpty()) {
			filmEntity = filmRepository.findById(Long.parseLong(request.getFilmId()));
		}
		if(!request.getUserId().isEmpty()) {
			userEntity = userRepository.findById(Long.parseLong(request.getUserId()));
		}
		if(!request.getMsg().isEmpty()) {
			entity.setContent(request.getMsg());
		}
		if(filmEntity.isPresent()) {
			entity.setFilm(filmEntity.get());
		}
		if(userEntity.isPresent()) {
			entity.setUser(userEntity.get());
		}
		userCommentFilmRepository.save(entity);
	}

	@Override
	public List<UserCommentFilmDTO> findAll() {
		
		List<UserCommentFilmDTO> results = new ArrayList<>();
		List<UserCommentFilmEntity> entities = userCommentFilmRepository.findAll();
		for(UserCommentFilmEntity e : entities) {
			UserCommentFilmDTO dto = mapper.map(e, UserCommentFilmDTO.class);
			// custom converter
			dto = converter.toDTO(dto, e);
			results.add(dto);
		}
		return results;
	}

	@Override
	public List<UserCommentFilmDTO> findAllByFilmId(String filmId) {
		
		List<UserCommentFilmDTO> results = new ArrayList<>();
		List<UserCommentFilmEntity> entities = userCommentFilmRepository.findAllByFilmId(Long.parseLong(filmId));
		for(UserCommentFilmEntity e : entities) {
			UserCommentFilmDTO dto = mapper.map(e, UserCommentFilmDTO.class);
			// custom converter
			dto = converter.toDTO(dto, e);
			results.add(dto);
		}
		return results;
	}

	@Override
	public List<UserCommentFilmDTO> findAllByFilmId(String filmId, Pageable pagable) {
		
		List<UserCommentFilmDTO> results = new ArrayList<>();
		List<UserCommentFilmEntity> entities = userCommentFilmRepository.findAllByFilmId(Long.parseLong(filmId), pagable);
		for(UserCommentFilmEntity e : entities) {
			UserCommentFilmDTO dto = mapper.map(e, UserCommentFilmDTO.class);
			// custom converter
			dto = converter.toDTO(dto, e);
			results.add(dto);
		}
		return results;
	}

	@Override
	public long countByFilmId(String filmId) {

		return userCommentFilmRepository.countByFilmId(Long.parseLong(filmId));
	}

}
