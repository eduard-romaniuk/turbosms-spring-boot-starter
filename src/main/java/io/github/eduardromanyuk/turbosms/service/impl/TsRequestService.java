package io.github.eduardromanyuk.turbosms.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Slf4j
@RequiredArgsConstructor
class TsRequestService {
	private final WebClient webClient;

	public <T> Mono<T> request(TsEndpoint endpoint, Object body, Class<T> responseType) {
		return webClient.post()
				.uri(endpoint.value())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.bodyValue(body)
				.retrieve()
				.bodyToMono(responseType);
	}

	public <T> Mono<T> request(TsEndpoint endpoint, Object body, ParameterizedTypeReference<T> responseType) {
		return webClient.post()
				.uri(endpoint.value())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.bodyValue(body)
				.retrieve()
				.bodyToMono(responseType);
	}

	public <T> Mono<T> request(TsEndpoint endpoint, ParameterizedTypeReference<T> responseType) {
		return webClient.post()
				.uri(endpoint.value())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.bodyToMono(responseType);
	}
}
