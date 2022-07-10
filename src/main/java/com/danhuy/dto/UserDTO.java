package com.danhuy.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO extends AbstractDTO<UserDTO> {

	@NotBlank(message = "{blankUsername}")
	@Size(min = 3, max = 50, message = "{usernameSize}")
	private String username;
	
	@NotBlank(message = "{blankPassword}")
	@Size(min = 3, max = 100, message = "{passwordSize}")
	private String password;
	
	private String fullName;
	private String email;
	private String phone;
	private Integer status;
	private String avatar;
}
