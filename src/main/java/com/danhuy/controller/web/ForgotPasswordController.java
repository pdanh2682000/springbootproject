package com.danhuy.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.danhuy.constants.SystemConstants;
import com.danhuy.dto.UserDTO;
import com.danhuy.service.IUserService;

@Controller
public class ForgotPasswordController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private JavaMailSender emailSender;
	
	@RequestMapping("/forgot")
	public ModelAndView forgot() {
		ModelAndView mav = new ModelAndView("web/forgot");
		return mav;
	}
	
	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ModelAndView doForgot(@RequestParam(value = "email", required = false) String email,
								@RequestParam(value = "password", required = false) String password) {
		ModelAndView mav = new ModelAndView("redirect:/forgot");
		try {
			UserDTO dto = userService.findOneByEmailAndStatus(email, SystemConstants.STATUS_ACTIVE);
			if(dto != null) {
				
				dto.setPassword(password);
				userService.save(dto);
				 // Create a Simple MailMessage.
		        SimpleMailMessage message = new SimpleMailMessage();
		       
		        message.setTo(dto.getEmail());
		        message.setSubject("Thay đổi mật khẩu thành công");
		        message.setText("Mật khẩu mới của bạn là: " + password);
	
		        // Send Message!
		        this.emailSender.send(message);
		        
		        mav.addObject("message", SystemConstants.SEND_EMAIL_SUCCESS);
				mav.addObject("alert", SystemConstants.ALERT_SUCCESS);
			}
			else {
				mav.addObject("message", SystemConstants.EMAIL_NOT_FOUND);
				mav.addObject("alert", SystemConstants.ALERT_DANGER);
			}
		} catch(Exception e) {
			mav.addObject("message", SystemConstants.SEND_EMAIL_FAIL);
			mav.addObject("alert", SystemConstants.ALERT_DANGER);
		}
		return mav;
	}
}
