package com.danhuy.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RateDTO extends AbstractDTO<RateDTO>{

	private String starNum;
	private String starInfo;
	private String starDescription;
}
