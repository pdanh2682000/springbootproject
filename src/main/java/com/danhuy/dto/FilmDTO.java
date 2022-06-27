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
public class FilmDTO extends AbstractDTO<FilmDTO> {

	@NotBlank(message = "{blankTitle}")
	@NotEmpty(message = "{emptyTitle}")
	private String title;
	@NotBlank(message = "{blankContent}")
	@NotEmpty(message = "{emptyContent}")
	private String content;
	private String shortDescription;
	private String url;
	private Long categoryId;
	@NotBlank(message = "{blankCategory}")
	@NotEmpty(message = "{emptyCategory}")
	private String categoryCode;
	private String categoryName;
	private String actor;
	private String author;
	private Integer posterSlide;
	private String publishDate;
	private Long filmLength;
}
