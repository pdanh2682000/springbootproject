package com.danhuy.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.danhuy.constants.SystemConstants;
import com.danhuy.dto.EpisodeDTO;
import com.danhuy.output.OutputResponse;
import com.danhuy.service.IEpisodeService;
import com.danhuy.service.IFilmService;
import com.danhuy.service.IUploadFileVideoService;

@Controller("episodeControllerOfAdmin")
public class EpisodeController {
	
	@Autowired
	private IEpisodeService episodeService;
	
	@Autowired
	private IFilmService filmService;
	
	@Autowired
	private IUploadFileVideoService uploadFileVideoService;

	@RequestMapping("/admin/episode/list")
	public ModelAndView viewEpisode(@RequestParam(value = "page", required = false) Integer page,
									@RequestParam(value = "limit", required = false) Integer limit) {
		try {
			ModelAndView mav = new ModelAndView("/admin/episode/list");
			List<EpisodeDTO> listEpisode = new ArrayList<>();
			OutputResponse<EpisodeDTO> out = new OutputResponse<>();
			listEpisode = episodeService.findAllForList();
			out.setResults(listEpisode);
			mav.addObject("list_episode", out);
			mav.addObject("menu", "menu_episode");
			return mav;
		}
		catch(Exception e) {
			ModelAndView mav = new ModelAndView("redirect:/admin");
			mav.addObject("message", SystemConstants.GET_LIST_CATEGORY_FAIL);
			mav.addObject("alert", SystemConstants.ALERT_DANGER);
			return mav;
		}
	}
	
	@RequestMapping("/admin/episode/add")
	public ModelAndView addEpisode() {
		ModelAndView mav = new ModelAndView("admin/episode/add");
		mav.addObject(new EpisodeDTO());
		mav.addObject("listFilmName", filmService.findAllName());
		return mav;
	}
	
	@RequestMapping(value = "/admin/episode/add", method = RequestMethod.POST)
	public ModelAndView doAddEpisode(@RequestParam(value = "file", required = false) MultipartFile file,
									@Validated EpisodeDTO dto,
									BindingResult result) {
		ModelAndView mav = null;
		try {
			if (result.hasErrors()) {
				if(file == null || file.isEmpty()) {
					mav = new ModelAndView("/admin/episode/add");
					mav.addObject("listFilmName", filmService.findAllName());
					mav.addObject("message", SystemConstants.BINDING_EPISODE_ERROR);
					mav.addObject("alert", SystemConstants.ALERT_DANGER);
					return mav;
				}
			}
			
			// upload file
			if(file != null && !file.isEmpty()) {
				String generatedFilename = uploadFileVideoService.storeFile(file, SystemConstants.UPLOAD_VIDEO);
				dto.setEpisodeUrl(generatedFilename);
			}
			
			episodeService.save(dto);
			mav = new ModelAndView("redirect:/admin/episode/add");
			mav.addObject("message", SystemConstants.CREATE_EPISODE_SUCCESS);
			mav.addObject("alert", SystemConstants.ALERT_SUCCESS);
			return mav;
		}
		catch(Exception e) {
			mav = new ModelAndView("redirect:/admin/episode/add");
			mav.addObject("message", SystemConstants.EDIT_EPISODE_FAIL);
			mav.addObject("alert", SystemConstants.ALERT_DANGER);
			return mav;
		}
	}
}
