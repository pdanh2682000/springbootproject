package com.danhuy.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.danhuy.constants.SystemConstants;
import com.danhuy.dto.FilmDTO;
import com.danhuy.dto.RateDTO;
import com.danhuy.output.OutputResponse;
import com.danhuy.service.IFilmService;
import com.danhuy.service.IRateService;

@Controller(value = "searchFilmControllerOfWeb")
public class SearchFilmController {

	@Autowired
	private IFilmService filmService;
	
	@Autowired
	private IRateService rateService;
	
	@RequestMapping("/search")
	public ModelAndView searchFilm(@RequestParam(value = "searchKey", required = false) String searchKey) {
		ModelAndView mav = new ModelAndView("web/search");
		OutputResponse<FilmDTO> outPosterContent= new OutputResponse<>();
		List<FilmDTO> listPosterContentTitle = filmService.findAllByTitle(searchKey);
		List<FilmDTO> listPosterContentActhor = filmService.findAllByActor(searchKey);
		List<RateDTO> listRate = rateService.findAll();
		listPosterContentTitle.addAll(listPosterContentActhor);
		outPosterContent.setResults(listPosterContentTitle);
		mav.addObject("poster_content", outPosterContent);
		mav.addObject("listRate", listRate);
		return mav;
	}
}
