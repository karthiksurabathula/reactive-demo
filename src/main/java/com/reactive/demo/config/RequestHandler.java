package com.reactive.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.demo.model.MathRequest;
import com.reactive.demo.model.MathResponse;
import com.reactive.demo.service.MathService;

import reactor.core.publisher.Mono;

@Service
public class RequestHandler {

	@Autowired
	private MathService mathService;

	public Mono<ServerResponse> multiplication(ServerRequest serverRequest) {

		Mono<MathRequest> reqBody = serverRequest.bodyToMono(MathRequest.class);
		return ServerResponse.ok().body(mathService.multiplication(reqBody), MathResponse.class);
	}

}
