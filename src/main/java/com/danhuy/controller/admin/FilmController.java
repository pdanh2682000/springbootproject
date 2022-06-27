package com.danhuy.controller.admin;

import java.util.ArrayList;
import java.util.List;

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
				mav.addObject("categories", categoryService.findAll());
			}
			// update
			else {
				mav.addObject(filmService.findById(id));
				mav.addObject("categories", categoryService.findAll());
			}

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

		try {
			if (result.hasErrors()) {
				ModelAndView mav = new ModelAndView("/admin/film/edit");
				mav.addObject("categories", categoryService.findAll());
				mav.addObject("message", SystemConstants.BINDING_FILM_ERROR);
				mav.addObject("alert", SystemConstants.ALERT_DANGER);
				return mav;
			}
			
			// upload file
			String generatedFilename = null;
			if(file != null)
				generatedFilename = uploadFileService.storeFile(file);
			
			// update
			if (id != null) {
				ModelAndView mav = new ModelAndView("redirect:/admin/film/edit?id=" + id);
				dto.setId(id);
				if(file != null)
					dto.setUrl(generatedFilename);
				filmService.save(dto);
				mav.addObject("message", SystemConstants.UPDATE_FILM_SUCCESS);
				mav.addObject("alert", SystemConstants.ALERT_SUCCESS);
				return mav;
			}
			// create
			else {
				ModelAndView mav = new ModelAndView("redirect:/admin/film/list");
				if(file != null)
					dto.setUrl(generatedFilename);
				filmService.save(dto);
				mav.addObject("message", SystemConstants.CREATE_FILM_SUCCESS);
				mav.addObject("alert", SystemConstants.ALERT_SUCCESS);
				return mav;
			}
		} catch (Exception e) {
			ModelAndView mav = new ModelAndView("redirect:/admin/film/list");
			mav.addObject("message", SystemConstants.EDIT_FILM_FAIL);
			mav.addObject("alert", SystemConstants.ALERT_DANGER);
			return mav;
		}
	}
}
