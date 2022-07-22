package com.danhuy.controller.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.danhuy.constants.SystemConstants;
import com.danhuy.dto.FilmDTO;
import com.danhuy.dto.RateDTO;
import com.danhuy.output.OutputResponse;
import com.danhuy.service.IFilmService;
import com.danhuy.service.IRateService;

@Controller(value = "HomeControllerOfWeb")
public class HomeController {

	@Autowired
	private IFilmService filmService;
	
	@Autowired
	private IRateService rateService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		
		ModelAndView mav = new ModelAndView("web/home");
		
		OutputResponse<FilmDTO> outPosterSlide = new OutputResponse<>();
		OutputResponse<FilmDTO> outPosterContent= new OutputResponse<>();
		
		List<FilmDTO> listPosterSlide = filmService.findAllByPosterSlide(SystemConstants.POSTER_SLIDE);
		List<FilmDTO> listPosterContent = filmService.findAllByPosterSlide(SystemConstants.POSTER_CONTENT);
		
		List<RateDTO> listRate = rateService.findAll();
		
		outPosterSlide.setResults(listPosterSlide);
		outPosterContent.setResults(listPosterContent);
		
		mav.addObject("poster_slide", outPosterSlide);
		mav.addObject("poster_content", outPosterContent);
		mav.addObject("listRate", listRate);
		return mav;
	}
}
