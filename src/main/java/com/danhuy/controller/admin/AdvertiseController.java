package com.danhuy.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
