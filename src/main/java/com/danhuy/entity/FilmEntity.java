package com.danhuy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "film")
public class FilmEntity extends BaseEntity {

	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "shortdescription")
	private String shortDescription;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "publish_date")
	private String publishDate;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "actor")
	private String actor;
	
	@Column(name = "poster_slide")
	private Integer posterSlide;
	
	@Column(name = "film_length", columnDefinition = "bigint default 0")
	private Long filmLength;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity category;
}
