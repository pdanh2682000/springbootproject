package com.danhuy.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.danhuy.constants.SystemConstants;
import com.danhuy.dto.UserDTO;
import com.danhuy.service.IUserService;

@Controller(value = "userProfileControllerOfWeb")
public class UserProfileController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/profile/{id}")
	public ModelAndView profile(@PathVariable(value = "id", required = false) Long id) {
		ModelAndView mav = new ModelAndView("profile/user_profile");
		UserDTO dto = userService.findById(id);
		if(id != null) {
			if(dto == null) {
				mav.addObject("message", "User not found!");
				mav.addObject("alert", "danger");
			}
			else {
				mav.addObject("modelUser", dto);
			}
		}
		return mav;
	}
}
