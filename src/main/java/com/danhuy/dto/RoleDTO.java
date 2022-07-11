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
public class RoleDTO extends AbstractDTO<RoleDTO>{
	
	@NotBlank(message = "{blankCodeRole}")
	@NotEmpty(message = "{emptyCodeRole}")
	private String code;
	@NotBlank(message = "{blankNameRole}")
	@NotEmpty(message = "{emptyNameRole}")
	private String name;
}