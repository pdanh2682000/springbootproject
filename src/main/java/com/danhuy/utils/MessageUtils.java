package com.danhuy.utils;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MessageUtils {

	private static MessageSource messageSource;
	
	public MessageUtils(MessageSource messageSource) {
		MessageUtils.messageSource = messageSource;
	}
	
	public static String getMessage(String messageKey, Object...args) {
		return messageSource.getMessage(messageKey, args, LocaleContextHolder.getLocale());
	}
	
	public static ModelAndView setMessageAndAlertForView(String message, String alert, ModelAndView mav) {
		mav.addObject("message", message);
		mav.addObject("alert", alert);
		return mav;
	}
}
