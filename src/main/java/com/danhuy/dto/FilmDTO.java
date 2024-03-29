package com.danhuy.dto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

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
	private String trailer;
	private String starNum;
	private String starInfo;
	// more info
	private Integer quantityRate = 0;
	private Integer everageRate = 0;
	// video
	private List<String> episodesUrl = new ArrayList<>();
	// advertise
	private List<Long> advertisesId = new ArrayList<>();
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date premiereDate;
}
