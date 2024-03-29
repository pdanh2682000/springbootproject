package com.danhuy.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO extends AbstractDTO<CategoryDTO>{
	
	@NotBlank(message = "{blankCode}")
	@NotEmpty(message = "{emptyCode}")
	private String code;
	@NotBlank(message = "{blankName}")
	@NotEmpty(message = "{emptyName}")
	private String name;
}