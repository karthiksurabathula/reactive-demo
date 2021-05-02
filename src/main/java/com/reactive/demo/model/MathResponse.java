package com.reactive.demo.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MathResponse {
	
	private Date date;
	private int result;
	
	public MathResponse(int result) {
		
		this.date = new Date();
		this.result = result;
	}
	
	

	
}
