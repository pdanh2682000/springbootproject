package com.danhuy.controller.admin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.danhuy.constants.SystemConstants;
import com.danhuy.dto.FilmDTO;
import com.danhuy.output.OutputResponse;
import com.danhuy.service.IAdvertiseService;
import com.danhuy.service.ICategoryService;
import com.danhuy.service.IFilmService;
import com.danhuy.service.IUploadFileService;
import com.danhuy.utils.MessageUtils;

@Controller(value = "FilmControllerOfAdmin")
public class FilmController {

	@Autowired
	private IFilmService filmService;

	@Autowired
	private ICategoryService categoryService;

	@Autowired
	private IUploadFileService uploadFileService;
	
	@Autowired
	private IAdvertiseService advertiseService;

	@RequestMapping("/admin/film/list")
	public ModelAndView listAll(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit, HttpServletRequest request) {

		try {
			ModelAndView mav = new ModelAndView("admin/film/list");
			List<FilmDTO> listFilms = new ArrayList<>();
			OutputResponse<FilmDTO> out = new OutputResponse<>();

			out.setPage(SystemConstants.DEFAULT_PAGE);
			out.setLimit(SystemConstants.DEFAULT_LIMIT_PAGE);
			if (page == null || limit == null)
				listFilms = filmService
						.findAll(PageRequest.of(SystemConstants.DEFAULT_PAGE - 1, SystemConstants.DEFAULT_LIMIT_PAGE));
			else {
				listFilms = filmService.findAll(PageRequest.of(page - 1, limit));
				out.setPage(page);
				out.setLimit(limit);
			}
			out.setResults(listFilms);
			out.setTotalItem(filmService.getTotalItem());
			out.setTotalPage((int) Math.ceil((double) out.getTotalItem() / out.getLimit()));

			mav.addObject("list_film", out);
			if (request.getParameter("message") != null && request.getParameter("alert") != null)
				MessageUtils.setMessageAndAlertForView(request.getParameter("message"), request.getParameter("alert"),
						mav);
			mav.addObject("menu", "menu_film");
			return mav;
		} catch (Exception e) {
			ModelAndView mav = new ModelAndView("redirect:/admin");
			mav.addObject("message", SystemConstants.GET_LIST_FILM_FAIL);
			mav.addObject("alert", SystemConstants.ALERT_DANGER);
			return mav;
		}
	}

	@RequestMapping(value = "/admin/film/edit")
	public ModelAndView editFilm(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {

		try {
			ModelAndView mav = new ModelAndView("admin/film/edit");
			// create
			if (id == null) {
				mav.addObject(new FilmDTO());
			}
			// update
			else {
				mav.addObject(filmService.findById(id));
			}
			mav.addObject("categories", categoryService.findAll());
			mav.addObject("advertises", advertiseService.findAllForMap());
			Map<Integer, String> contentSlide = new HashMap<>();
			contentSlide.put(SystemConstants.POSTER_SLIDE, SystemConstants.HAVE_POSTER_SLIDE);
			contentSlide.put(SystemConstants.POSTER_CONTENT, SystemConstants.NO_POSTER_SLIDE);
			mav.addObject("contentSlide", contentSlide);

			if (request.getParameter("message") != null && request.getParameter("alert") != null)
				MessageUtils.setMessageAndAlertForView(request.getParameter("message"), request.getParameter("alert"),
						mav);
			return mav;
		} catch (Exception e) {
			ModelAndView mav = new ModelAndView("redirect:/admin/film/list");
			mav.addObject("message", SystemConstants.GET_INFO_EDIT_FILM_FAIL);
			mav.addObject("alert", SystemConstants.ALERT_DANGER);
			return mav;
		}
	}

	@RequestMapping(value = "/admin/film/edit", method = RequestMethod.POST)
	public ModelAndView doEditFilm(	@RequestParam(value = "id", required = false) Long id,
									@RequestParam(value = "file", required = false) MultipartFile file,
									@Validated FilmDTO dto,
									BindingResult result) {
		
		ModelAndView mav = null;
		try {
			if (result.hasErrors()) {
				mav = new ModelAndView("/admin/film/edit");
				mav.addObject("categories", categoryService.findAll());
				mav.addObject("advertises", advertiseService.findAllForMap());
				Map<Integer, String> contentSlide = new HashMap<>();
				contentSlide.put(SystemConstants.POSTER_SLIDE, SystemConstants.HAVE_POSTER_SLIDE);
				contentSlide.put(SystemConstants.POSTER_CONTENT, SystemConstants.NO_POSTER_SLIDE);
				mav.addObject("contentSlide", contentSlide);
				mav.addObject("message", SystemConstants.BINDING_FILM_ERROR);
				mav.addObject("alert", SystemConstants.ALERT_DANGER);
				return mav;
			}
			
			// upload file
			if(file != null && !file.isEmpty()) {
				if(dto.getPosterSlide() != null ) {
					if(dto.getPosterSlide() == 0) {
						String generatedFilename = uploadFileService.storeFile(file, SystemConstants.UPLOAD_POSTER_CONTENT);
						dto.setUrl(generatedFilename);
					}
					else if(dto.getPosterSlide() == 1) {
						String generatedFilename = uploadFileService.storeFile(file, SystemConstants.UPLOAD_POSTER_SLIDE);
						dto.setUrl(generatedFilename);
					}
				}
				else {
					String generatedFilename = uploadFileService.storeFile(file, SystemConstants.UPLOAD_POSTER_CONTENT);
					dto.setUrl(generatedFilename);
				}
			}
			
			// update
			if (id != null) {
				mav = new ModelAndView("redirect:/admin/film/edit?id=" + id);
				dto.setId(id);
				mav.addObject("message", SystemConstants.UPDATE_FILM_SUCCESS);
			}
			// create
			else {
				mav = new ModelAndView("redirect:/admin/film/list");
				mav.addObject("message", SystemConstants.CREATE_FILM_SUCCESS);
			}
			mav.addObject("alert", SystemConstants.ALERT_SUCCESS);
			filmService.save(dto);
			return mav;
		} catch (Exception e) {
			mav = new ModelAndView("redirect:/admin/film/list");
			mav.addObject("message", SystemConstants.EDIT_FILM_FAIL);
			mav.addObject("alert", SystemConstants.ALERT_DANGER);
			return mav;
		}
	}
}
