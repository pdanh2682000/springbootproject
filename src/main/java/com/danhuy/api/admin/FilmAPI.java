package com.danhuy.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.danhuy.service.IFilmService;

@RestController(value = "Film API Of Admin")
public class FilmAPI {

	@Autowired
	private IFilmService filmService;
	
	@DeleteMapping("/api/film")
	public void deleteFilm(@RequestBody long[] ids) {
		filmService.delete(ids);
	}
}
