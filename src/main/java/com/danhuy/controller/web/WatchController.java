package com.danhuy.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.danhuy.dto.FilmDTO;
import com.danhuy.service.IFilmService;

@Controller(value = "watchControllerOfWeb")
public class WatchController {

	@Autowired
	private IFilmService filmService;	
	
	@RequestMapping("/watch/{id}")
	public ModelAndView watchMovie(@PathVariable("id") Long id) {
		ModelAndView mav = new ModelAndView("/watch/watch_movie");
		FilmDTO dto = filmService.findById(id);
		if(dto != null) {
			mav.addObject("poster", dto);
			mav.addObject("episode", dto.getEpisodesUrl().get(0));
		}
		else {
			mav.addObject("poster", new FilmDTO());
		}
		return mav;
	}
	
}
