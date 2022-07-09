package com.danhuy.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.danhuy.constants.SystemConstants;
import com.danhuy.dto.FilmDTO;
import com.danhuy.output.OutputResponse;
import com.danhuy.service.IFilmService;

@Controller(value = "HomeControllerOfWeb")
public class HomeController {

	@Autowired
	private IFilmService filmService;
	
	@RequestMapping("/")
	public ModelAndView home() {
		
		ModelAndView mav = new ModelAndView("web/home");
		
		OutputResponse<FilmDTO> outPosterSlide = new OutputResponse<>();
		OutputResponse<FilmDTO> outPosterContent= new OutputResponse<>();
		
		List<FilmDTO> listPosterSlide = filmService.findAllByPosterSlide(SystemConstants.POSTER_SLIDE);
		List<FilmDTO> listPosterContent = filmService.findAllByPosterSlide(SystemConstants.POSTER_CONTENT);
		
		outPosterSlide.setResults(listPosterSlide);
		outPosterContent.setResults(listPosterContent);
		
		mav.addObject("poster_slide", outPosterSlide);
		mav.addObject("poster_content", outPosterContent);
		return mav;
	}
	
	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping("/logout")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("redirect:/");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if(auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return mav;
	}
}
