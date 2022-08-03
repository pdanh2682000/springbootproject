package com.danhuy.controller.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.danhuy.constants.SystemConstants;
import com.danhuy.dto.UserDTO;
import com.danhuy.service.IUserService;
import com.danhuy.utils.MessageUtils;

@Controller(value = "SignInOrUpController")
public class SignInUpController {
	
	@Autowired
	private IUserService userService;

	@RequestMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("web/login");
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
	
	@RequestMapping("/signup")
	public ModelAndView signup(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("web/signup");
		mav.addObject(new UserDTO());
		if (request.getParameter("message") != null && request.getParameter("alert") != null)
			MessageUtils.setMessageAndAlertForView(request.getParameter("message"), request.getParameter("alert"),
					mav);
		return mav;
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView doSignup(@Validated UserDTO user, BindingResult result) {
		
		ModelAndView mav = new ModelAndView("/web/signup");
		mav.addObject("alert", SystemConstants.ALERT_DANGER);
		if(result.hasErrors()) {
			mav.addObject("message", SystemConstants.BINDING_USER_ERROR);
			return mav;
		}
		if(user.getUsername().isEmpty() || userService.existsByUsername(user.getUsername())) {
			mav.addObject("message", SystemConstants.EXISTS_USERNAME);
			return mav;
		}
		if(user.getEmail().isEmpty() || userService.existsByEmail(user.getEmail())) {
			mav.addObject("message", SystemConstants.EXISTS_EMAIL);
			return mav;
		}
		userService.save(user);
		mav = new ModelAndView("redirect:/login");
		mav.addObject("message", SystemConstants.REGISTER_ACCOUNT_SUCCESS);
		mav.addObject("alert", SystemConstants.ALERT_SUCCESS);
		return mav;
	}
}
