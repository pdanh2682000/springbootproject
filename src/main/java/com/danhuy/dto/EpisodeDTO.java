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

	private String episodeName;
	private String episode;
	private String episodeDescription;
	
	@NotBlank(message = "{blankFilmId}")
	private String filmId;
	private String filmName;
	
	@NotBlank(message = "{blankEpisodeUrl}")
	private String episodeUrl;
}
