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
import com.danhuy.dto.UserDTO;
import com.danhuy.output.OutputResponse;
import com.danhuy.service.IRoleService;
import com.danhuy.service.IUploadFileService;
import com.danhuy.service.IUserService;
import com.danhuy.utils.MessageUtils;

@Controller("userControllerOfAdmin")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IRoleService roleService;
	
	@Autowired
	private IUploadFileService uploadFileService;

	@RequestMapping("/admin/user/list")
	public ModelAndView listUser(@RequestParam(value = "page", required = false) Integer page,
			@RequestParam(value = "limit", required = false) Integer limit, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/user/list");
		List<UserDTO> listUsers = new ArrayList<>();
		OutputResponse<UserDTO> out = new OutputResponse<>();

		out.setPage(SystemConstants.DEFAULT_PAGE);
		out.setLimit(SystemConstants.DEFAULT_LIMIT_PAGE);
		if (page == null || limit == null) {
			listUsers = userService.findAll(PageRequest.of(out.getPage() - 1, out.getLimit()));
		} else {
			listUsers = userService.findAll(PageRequest.of(page - 1, limit));
			out.setPage(page);
			out.setLimit(limit);
		}
		out.setResults(listUsers);
		out.setTotalItem(userService.getTotalItem());
		out.setTotalPage((int) Math.ceil((double) out.getTotalItem() / out.getLimit()));

		mav.addObject("list_user", out);
		if (request.getParameter("message") != null && request.getParameter("alert") != null)
			MessageUtils.setMessageAndAlertForView(request.getParameter("message"), request.getParameter("alert"), mav);
		mav.addObject("menu", "menu_user");
		if (request.getParameter("message") != null && request.getParameter("alert") != null)
			MessageUtils.setMessageAndAlertForView(request.getParameter("message"), request.getParameter("alert"), mav);
		return mav;
	}

	@RequestMapping("/admin/user/edit")
	public ModelAndView editUser(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("/admin/user/edit");
		// create
		if (id == null)
			mav.addObject(new UserDTO());
		// update
		else {
			mav.addObject(userService.findById(id));
		}
		mav.addObject("roles", roleService.findAllMap());
		if (request.getParameter("message") != null && request.getParameter("alert") != null)
			MessageUtils.setMessageAndAlertForView(request.getParameter("message"), request.getParameter("alert"), mav);
		return mav;
	}

	@RequestMapping(value = "/admin/user/edit", method = RequestMethod.POST)
	public ModelAndView doEditUser(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "file", required = false) MultipartFile file, @Validated UserDTO dto,
			BindingResult result) {
		
		ModelAndView mav = new ModelAndView();
		try {
			if (result.hasErrors()) {
				mav = new ModelAndView("/admin/user/edit");
				mav.addObject("roles", roleService.findAllMap());
				mav.addObject("message", SystemConstants.BINDING_USER_ERROR);
				mav.addObject("alert", SystemConstants.ALERT_DANGER);
				return mav;
			}
			
			// upload file
			if (file != null && !file.isEmpty()) {
				String generatedFilename = uploadFileService.storeFile(file, SystemConstants.UPLOAD_AVATAR);
				dto.setAvatar(generatedFilename);
			}
	
			// update
			if (id != null) {
				mav = new ModelAndView("redirect:/admin/user/edit?id=" + id);
				dto.setId(id);
				mav.addObject("message", SystemConstants.UPDATE_USER_SUCCESS);
			}
			// create
			else {
				if(!dto.getUsername().isEmpty()) {
					if(userService.existsByUsername(dto.getUsername())) {
						mav = new ModelAndView("/admin/user/edit");
						mav.addObject("roles", roleService.findAllMap());
						mav.addObject("message", SystemConstants.EXISTS_USERNAME);
						mav.addObject("alert", SystemConstants.ALERT_DANGER);
						return mav;
					}
				}
				
				if(!dto.getEmail().isEmpty()) {
					if(userService.existsByEmail(dto.getEmail())) {
						mav = new ModelAndView("/admin/user/edit");
						mav.addObject("roles", roleService.findAllMap());
						mav.addObject("message", SystemConstants.EXISTS_EMAIL);
						mav.addObject("alert", SystemConstants.ALERT_DANGER);
						return mav;
					}
				}
				mav = new ModelAndView("redirect:/admin/user/list");
				mav.addObject("message", SystemConstants.CREATE_USER_SUCCESS);
			}
			mav.addObject("alert", SystemConstants.ALERT_SUCCESS);
			userService.save(dto);
			return mav;
		}
		catch (Exception e) {
			e.printStackTrace();
			mav = new ModelAndView("redirect:/admin/user/list");
			mav.addObject("message", SystemConstants.EDIT_USER_FAIL);
			mav.addObject("alert", SystemConstants.ALERT_DANGER);
			return mav;
		}
	}
}
