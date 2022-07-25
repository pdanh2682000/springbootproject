package com.danhuy.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDTO extends AbstractDTO<EpisodeDTO>{

	private String episode_name;
	private String episode;
	private String episode_description;
	
	@NotBlank
	private String episode_url;
}
