package com.danhuy.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.danhuy.constants.SystemConstants;
import com.danhuy.dto.FilmDTO;
import com.danhuy.service.IFilmService;

@Controller(value = "watchControllerOfWeb")
public class WatchController {

	@Autowired
	private IFilmService filmService;	
	
	@RequestMapping("/watch/{id}")
	public ModelAndView watchMovie(	@PathVariable("id") Long id,
									@RequestParam(value = "ep", required = false) Integer ep) {
		try {
			ModelAndView mav = new ModelAndView("/watch/watch_movie");
			FilmDTO dto = filmService.findById(id);
			if(dto != null) {
				mav.addObject("poster", dto);
				if(!dto.getEpisodesUrl().isEmpty()) {
					if(ep == null)	
						mav.addObject("episode", dto.getEpisodesUrl().get(SystemConstants.DEFAULT_EPISODE_MOVIE));
					else
						mav.addObject("episode", dto.getEpisodesUrl().get(ep-1));
				}
				if(dto.getEpisodesUrl().size() <= SystemConstants.DEFAULT_LENGTH_EPISODE_MOVIE + 1) {
					mav.addObject("length_episode", SystemConstants.DEFAULT_LENGTH_EPISODE_MOVIE);
					mav.addObject("ep_current", SystemConstants.DEFAULT_EPISODE_MOVIE);
				}
				else {
					mav.addObject("length_episode", dto.getEpisodesUrl().size());
					mav.addObject("list_episode", dto.getEpisodesUrl());
					if(ep == null)
						mav.addObject("ep_current", SystemConstants.DEFAULT_EPISODE_MOVIE + 1);
					else
						mav.addObject("ep_current", ep);
				}
			}
			else {
				mav = new ModelAndView("redirect:/");
			}
			return mav;
		}
		catch(Exception e) {
			ModelAndView mav = new ModelAndView("redirect:/");
			return mav;
		}
	}
	
	
	
}
