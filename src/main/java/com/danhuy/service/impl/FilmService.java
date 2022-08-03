package com.danhuy.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danhuy.converter.CustomFilmConverter;
import com.danhuy.dto.FilmDTO;
import com.danhuy.entity.AdvertiseEntity;
import com.danhuy.entity.CategoryEntity;
import com.danhuy.entity.EpisodeEntity;
import com.danhuy.entity.FilmEntity;
import com.danhuy.entity.RateEntity;
import com.danhuy.repository.AdvertiseRepository;
import com.danhuy.repository.CategoryRepository;
import com.danhuy.repository.FilmRepository;
import com.danhuy.repository.RateRepository;
import com.danhuy.service.IFilmService;
import com.danhuy.service.IUploadFileService;

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
	
	@Autowired
	private RateRepository rateRepository;
	
	@Autowired
	private IUploadFileService uploadFileService;
	
	@Autowired
	private AdvertiseRepository advertiseRepository;
	
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
			dto.setQuantityRate(e.getRates().size());
			dto.setEverageRate(everageRatePerFilm(e));
			results.add(dto);
		}
		return results;
	}
	
	public int everageRatePerFilm(FilmEntity entity) {
		
		int result = 0;
		for(RateEntity rate : entity.getRates()) {
			result += Integer.parseInt(rate.getStarNum());
		}
		return  (entity.getRates().size() > 0) ? (int)Math.ceil((double)result / (entity.getRates().size())) : 0;
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
		if(filmEntity.getPosterSlide() == null)
			filmEntity.setPosterSlide(0); // default is poster content
		if(dto.getAdvertisesId() != null) {
			for(Long advertiseId : dto.getAdvertisesId()) {
				Optional<AdvertiseEntity> advertiseEntity = advertiseRepository.findById(advertiseId);
				if(advertiseEntity.isPresent()) {
					Set<AdvertiseEntity> currentListAdvertise = filmEntity.getAdvertises();
					currentListAdvertise.add(advertiseEntity.get());
					filmEntity.setAdvertises(currentListAdvertise);
				}
			}
		}
		filmEntity.setPremiereDate(new Date(dto.getPremiereDate().getTime()));
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
			dto.setQuantityRate(entity.get().getRates().size());
			dto.setEverageRate(everageRatePerFilm(entity.get()));
			// episode
			List<EpisodeEntity> listEpisode = entity.get().getEpisodes();
			List<String> listEpisodeStr = new ArrayList<>();
			for(EpisodeEntity e : listEpisode) {
				listEpisodeStr.add(e.getEpisodeUrl());
			}
			dto.setEpisodesUrl(listEpisodeStr);
			return dto;
		}
		return null;
	}

	@Override
	@Transactional
	public void delete(long[] ids) {
		
		for(long id : ids) {
			Optional<FilmEntity> entity = filmRepository.findById(id);
			if(entity.isPresent()) {
				uploadFileService.deleteFile(entity.get().getUrl()); // delete file poster
			}
			filmRepository.deleteById(id);
		}
	}

	@Override
	@Transactional
	public void addFilmRate(String filmId, String starNum) {
		
		Optional<FilmEntity> filmEntity = filmRepository.findById(Long.parseLong(filmId));
		RateEntity rateEntity = rateRepository.findByStarNum(starNum);
		if(filmEntity.get() != null && rateEntity != null) {
			filmEntity.get().getRates().add(rateEntity);
		}
		filmRepository.save(filmEntity.get());
	}

	@Override
	public long countQuantityFilmRate(String filmId) {
		
		Optional<FilmEntity> filmEntity = filmRepository.findById(Long.parseLong(filmId));
		if(filmEntity != null && !filmEntity.isEmpty()) {
			List<RateEntity> rateEntity = filmEntity.get().getRates();
			return rateEntity.size();
		}
		return 0;
	}

	@Override
	public Map<String, String> findAllName() {
		
		Map<String, String> results = new HashMap<>();
		List<FilmEntity> entities = filmRepository.findAll();
		for(FilmEntity e : entities) {
			results.put(e.getId().toString(), e.getTitle());
		}
		return results;
	}
}
