package com.danhuy.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdvertiseDTO extends AbstractDTO<AdvertiseDTO> {

	private String titleAdvertise;
	private String descriptionAdvertise;
	private Set<FilmDTO> films = new HashSet<>();
}
