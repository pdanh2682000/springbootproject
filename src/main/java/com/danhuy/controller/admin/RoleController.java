package com.danhuy.controller.admin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.danhuy.constants.SystemConstants;
import com.danhuy.dto.RoleDTO;
import com.danhuy.output.OutputResponse;
import com.danhuy.service.IRoleService;

@Controller(value = "RoleControllerOfAdmin")
public class RoleController {

	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("/admin/role/list")
	public ModelAndView listRole() {
		
		ModelAndView mav = new ModelAndView("admin/role/list");
		List<RoleDTO> listRole = new ArrayList<>();
		OutputResponse<RoleDTO> out = new OutputResponse<>();
		listRole = roleService.findAll();
		out.setResults(listRole);
		mav.addObject("list_role", out);
		mav.addObject("menu", "menu_role");
		return mav;
	}
	
	@RequestMapping("/admin/role/add")
	public ModelAndView addRole() {
		ModelAndView mav = new ModelAndView("admin/role/add");
		mav.addObject(new RoleDTO());
		return mav;
	}
	
	@RequestMapping(value = "/admin/role/add", method = RequestMethod.POST)
	public ModelAndView doAddRole(@Validated RoleDTO dto, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		try {
			if(result.hasErrors()) {
				mav = new ModelAndView("/admin/role/add");
				mav.addObject("message", SystemConstants.BINDING_USER_ERROR);
				mav.addObject("alert", SystemConstants.ALERT_DANGER);
				return mav;
			}
			if(roleService.existsByCode(dto.getCode())) {
				mav = new ModelAndView("/admin/role/add");
				mav.addObject("message", SystemConstants.EXISTS_CODE);
				mav.addObject("alert", SystemConstants.ALERT_DANGER);
				return mav;
			}
			if(!dto.getName().isEmpty() && !dto.getCode().isEmpty()) {
				mav = new ModelAndView("redirect:/admin/role/list");
				roleService.save(dto);
				mav.addObject("message", SystemConstants.CREATE_ROLE_SUCCESS);
				mav.addObject("alert", SystemConstants.ALERT_SUCCESS);
				return mav;
			}
		} catch(Exception e) {
			mav = new ModelAndView("redirect:/admin/role/list");
			mav.addObject("message", SystemConstants.CREATE_ROLE_FAIL);
			mav.addObject("alert", SystemConstants.ALERT_DANGER);
		}
		return mav;
	}
}
