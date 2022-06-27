package com.danhuy.output;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class OutputResponse<T> {

	private String status;
	private String message;
	private Integer page;
	private Integer limit;
	private Integer totalPage;
	private Long totalItem;
	private String alert;
	private List<T> results = new ArrayList<>();
}
