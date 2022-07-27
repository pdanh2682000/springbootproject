package com.danhuy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "episode")
public class EpisodeEntity extends BaseEntity{

	@Column
	private String episodeName;
	
	@Column
	private String episode; // full, 1, 2, 3, ...
	
	@Column
	private String episodeDescription;
	
	@Column
	@NotBlank
	private String episodeUrl;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id")
	private FilmEntity film;
	
}
