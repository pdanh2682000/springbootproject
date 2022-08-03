package com.danhuy.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "advertise")
public class AdvertiseEntity extends BaseEntity {

	@Column
	private String titleAdvertise;
	
	@Column
	private String descriptionAdvertise;
	
	@ManyToMany(mappedBy = "advertises")
	private List<FilmEntity> films = new ArrayList<>();
}
