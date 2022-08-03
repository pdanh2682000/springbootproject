package com.danhuy.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.danhuy.request.RateFilmRequest;
import com.danhuy.service.IFilmService;

@RestController(value = "Film API Of Admin")
public class FilmAPI {

	@Autowired
	private IFilmService filmService;
	
	@DeleteMapping("/api/film")
	public void deleteFilm(@RequestBody long[] ids) {
		filmService.delete(ids);
	}
	
	@PostMapping("/api/film/rate")
	public String addFilmRate(@RequestBody RateFilmRequest request) {
		filmService.addFilmRate(request.getFilmId(), request.getStarNum());
		return request.getFilmId();
	}
}
