package com.reactive.demo.service;

import org.springframework.stereotype.Service;

import com.reactive.demo.exception.InputValidationException;
import com.reactive.demo.model.MathRequest;
import com.reactive.demo.model.MathResponse;

import reactor.core.publisher.Mono;

@Service
public class MathService {

	public Mono<MathResponse> multiplication(Mono<MathRequest> mathRequest) {

		return mathRequest.handle((req, sink) -> {
			if (req.getA() >= 10 && req.getA() <= 30) {
				sink.next(req);
			} else {
				sink.error(new InputValidationException(100, req.getA()));
			}

		}).cast(MathRequest.class).flatMap(r -> Mono.just(new MathResponse(r.getA())));
	}

}
