package com.danhuy.dto;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdvertiseDTO extends AbstractDTO<AdvertiseDTO> {

	@NotBlank(message = "{blankTitleAdvertise}")
	private String titleAdvertise;
	
	@NotBlank(message = "{blankDescriptionAdvertise}")
	private String descriptionAdvertise;
	private Set<FilmDTO> films = new HashSet<>();
}
