package com.danhuy.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
				mav.addObject("message", SystemConstants.USER_NOT_FOUND);
				mav.addObject("alert", SystemConstants.ALERT_DANGER);
			}
			else {
				mav.addObject("modelUser", dto);
			}
		}
		mav.addObject("menu", "about");
		return mav;
	}
	
	@RequestMapping("/profile")
	public ModelAndView profileError(@RequestParam(value = "not_login", required = false) String statusLogin) {
		ModelAndView mav = new ModelAndView("profile/user_profile");
		if(statusLogin != null) {
			mav.addObject("message", SystemConstants.NOT_LOGIN);
			mav.addObject("alert", SystemConstants.ALERT_DANGER);
		}
		mav.addObject("menu", "about");
		return mav;
	}
}
