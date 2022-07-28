package com.danhuy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "user_comment_film")
public class UserCommentFilmEntity extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "userid", referencedColumnName = "id")
	private UserEntity user;
	
	@ManyToOne
	@JoinColumn(name = "filmid", referencedColumnName = "id")
	private FilmEntity film;
	
	@Column
	private String content;
}
