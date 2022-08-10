package com.danhuy.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.danhuy.constants.SystemConstants;
import com.danhuy.dto.AdvertiseDTO;
import com.danhuy.output.OutputResponse;
import com.danhuy.service.IAdvertiseService;

@Controller(value = "advertiseControllerOfWeb")
public class AdvertiseController {

	@Autowired
	private IAdvertiseService advertiseService;
	
	@RequestMapping("/admin/advertise/list")
	public ModelAndView showAll() {
		ModelAndView mav = new ModelAndView("admin/advertise/list");
		OutputResponse<AdvertiseDTO> out = new OutputResponse<>();
		List<AdvertiseDTO> listAdvertise = advertiseService.findAll();
		out.setResults(listAdvertise);
		mav.addObject("list_advertise", out);
		mav.addObject("menu", "menu_advertise");
		return mav;
	}
	
	@RequestMapping("/admin/advertise/add")
	public ModelAndView addAdvertise() {
		ModelAndView mav = new ModelAndView("admin/advertise/add");
		mav.addObject(new AdvertiseDTO());
		return mav;
	}
	
	@RequestMapping(value = "/admin/advertise/add", method = RequestMethod.POST)
	public ModelAndView doAddAdvertise( @Validated AdvertiseDTO dto,
										BindingResult result) {
		ModelAndView mav = new ModelAndView();
		try {
			if(result.hasErrors()) {
				mav = new ModelAndView("/admin/advertise/add");
				mav.addObject("message", SystemConstants.BINDING_ADVERTISE_ERROR);
				mav.addObject("alert", SystemConstants.ALERT_DANGER);
				return mav;
			}
			mav = new ModelAndView("redirect:/admin/advertise/list");
			advertiseService.save(dto);
			mav.addObject("message", SystemConstants.CREATE_ADVERTISE_SUCCESS);
			mav.addObject("alert", SystemConstants.ALERT_SUCCESS);
			return mav;
		}
		catch(Exception e) {
			mav = new ModelAndView("redirect:/admin/advertise/list");
			mav.addObject("message", SystemConstants.EDIT_ADVERTISE_FAIL);
			mav.addObject("alert", SystemConstants.ALERT_DANGER);
		}
		return mav;
	}
}
