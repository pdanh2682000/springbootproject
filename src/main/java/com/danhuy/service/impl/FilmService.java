package com.danhuy.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danhuy.converter.CustomFilmConverter;
import com.danhuy.dto.FilmDTO;
import com.danhuy.entity.CategoryEntity;
import com.danhuy.entity.FilmEntity;
import com.danhuy.repository.CategoryRepository;
import com.danhuy.repository.FilmRepository;
import com.danhuy.service.IFilmService;

@Service
public class FilmService implements IFilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	@Autowired
    private ModelMapper mapper;
	
	@Autowired
	private CustomFilmConverter converter;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<FilmDTO> findAll() {
		
		List<FilmDTO> results = new ArrayList<>();
		List<FilmEntity> entities = filmRepository.findAll();
		for(FilmEntity e : entities) {
			FilmDTO dto = mapper.map(e, FilmDTO.class);
			// custom convert
			converter.toDTO(dto, e);
			results.add(dto);
		}
		return results;
	}

	@Override
	public List<FilmDTO> findAllByPosterSlide(int status) {
		
		List<FilmDTO> results = new ArrayList<>();
		List<FilmEntity> entities = filmRepository.findAllByPosterSlide(status);
		for(FilmEntity e : entities) {
			FilmDTO dto = mapper.map(e, FilmDTO.class);
			// custom convert
			converter.toDTO(dto, e);
			results.add(dto);
		}
		return results;
	}

	@Override
	public List<FilmDTO> findAll(Pageable pageable) {
		
		List<FilmDTO> results = new ArrayList<>();
		List<FilmEntity> entities = filmRepository.findAll(pageable).getContent();
		for(FilmEntity e : entities) {
			FilmDTO dto = mapper.map(e, FilmDTO.class);
			// custom convert
			dto = converter.toDTO(dto, e);
			results.add(dto);
		}
		return results;
	}

	@Override
	public long getTotalItem() {
		
		return filmRepository.count();
	}

	@Override
	@Transactional
	public FilmDTO save(FilmDTO dto) {
		
		FilmEntity filmEntity = new FilmEntity();
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(dto.getCategoryCode());
		// update
		if(dto.getId() != null) {
			Optional<FilmEntity> oldFilmEntity = filmRepository.findById(dto.getId());
			if(oldFilmEntity.isPresent()) {
				if(dto.getUrl() == null || dto.getUrl().isEmpty())
					dto.setUrl(oldFilmEntity.get().getUrl()); // set url from old
				filmEntity = converter.toEntity(oldFilmEntity.get(), dto);
			}
		}
		// create
		else {
			filmEntity = mapper.map(dto, FilmEntity.class);
		}
		filmEntity.setPosterSlide(0); // default is poster content
		filmEntity.setCategory(categoryEntity);
		return mapper.map(filmRepository.save(filmEntity), FilmDTO.class);
	}

	@Override
	public FilmDTO findById(Long id) {
		
		Optional<FilmEntity> entity = filmRepository.findById(id);
		if(entity.isPresent()) {
			FilmDTO dto = mapper.map(entity.get(), FilmDTO.class);
			// custom convert
			dto = converter.toDTO(dto, entity.get());
			return dto;
		}
		return null;
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		for(long id : ids) {
			filmRepository.deleteById(id);
		}
	}
}
