package com.reactive.demo.config;

import java.util.function.BiFunction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.reactive.demo.exception.InputValidationException;

import reactor.core.publisher.Mono;

@Configuration
public class RouterConfig {
	
	@Autowired
	private RequestHandler reqHandler;
	
	@Bean
	public RouterFunction<ServerResponse> highRouterConfig() {
		return RouterFunctions.route()
				.path("router", this::RouterConfig)
				.build();
	}


	private RouterFunction<ServerResponse> RouterConfig() {
		return RouterFunctions.route()
				.POST("math", reqHandler::multiplication)
				.onError(InputValidationException.class, exceptionHandler())
				.build();
	}


	private BiFunction<? super Throwable, ServerRequest, Mono<ServerResponse>> exceptionHandler() {
		return (err, input) -> {
			InputValidationException ex = (InputValidationException)err;
			InputFailedValidationResponse errResp = new InputFailedValidationResponse();
			errResp.setErrorCode(ex.getErrorCode());
			errResp.setInput(ex.getInput());
			errResp.setMessage(ex.getMessage());
			return ServerResponse.badRequest().bodyValue(errResp);
		};
	}
	

	
}
