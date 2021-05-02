package com.reactive.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.demo.model.MathRequest;
import com.reactive.demo.model.MathResponse;
import com.reactive.demo.service.MathService;

import reactor.core.publisher.Mono;

@RestController
public class MathController {

	@Autowired
	private MathService mathService;

	@PostMapping("/math")
	public Mono<MathResponse> mathMultiply(@RequestBody Mono<MathRequest> mathrequest) {
		return mathService.multiplication(mathrequest);
	}

}
