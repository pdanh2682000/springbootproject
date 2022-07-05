package com.danhuy.controller.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.danhuy.constants.SystemConstants;
import com.danhuy.dto.CategoryDTO;
import com.danhuy.output.OutputResponse;
import com.danhuy.service.ICategoryService;

@Controller(value = "CategoryControllerOfAdmin")
public class CategoryController {

	@Autowired
	private ICategoryService categoryService;
	
	@RequestMapping("/admin/category/list")
	public ModelAndView listAll(@RequestParam(value = "page", required = false) Integer page,
								@RequestParam(value = "limit", required = false) Integer limit, HttpServletRequest request) {
		try {
			ModelAndView mav = new ModelAndView("/admin/category/list");
			List<CategoryDTO> listCategory = new ArrayList<>();
			OutputResponse<CategoryDTO> out = new OutputResponse<>();
			listCategory = categoryService.findAllForList();
			out.setResults(listCategory);
			mav.addObject("list_category", out);
			return mav;
		}
		catch(Exception e) {
			ModelAndView mav = new ModelAndView("redirect:/admin");
			mav.addObject("message", SystemConstants.GET_LIST_CATEGORY_FAIL);
			mav.addObject("alert", SystemConstants.ALERT_DANGER);
			return mav;
		}
	}
}
