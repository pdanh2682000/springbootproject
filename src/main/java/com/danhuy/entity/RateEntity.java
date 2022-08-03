package com.danhuy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "rate", uniqueConstraints = {
		@UniqueConstraint(columnNames = {
				"starNum"
		})
})
public class RateEntity extends BaseEntity {

	@Column
	@NotBlank
	private String starNum;
	
	@Column
	private String starInfo;
	
	@Column
	private String starDescription;
	
	@ManyToMany(mappedBy = "rates")
	private List<FilmEntity> films = new ArrayList<>();
}
