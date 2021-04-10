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
	private static final String TOKEN_QUERY_PARAM = "token";
	private final WebClient webClient;
	private final String accessToken;

	public <T> Mono<T> request(TsEndpoint endpoint, Object body, Class<T> responseType) {
		return request(endpoint)
				.bodyValue(body)
				.retrieve()
				.bodyToMono(responseType);
	}

	public <T> Mono<T> request(TsEndpoint endpoint, Object body, ParameterizedTypeReference<T> responseType) {
		return request(endpoint)
				.bodyValue(body)
				.retrieve()
				.bodyToMono(responseType);
	}

	public <T> Mono<T> request(TsEndpoint endpoint, ParameterizedTypeReference<T> responseType) {
		return request(endpoint)
				.retrieve()
				.bodyToMono(responseType);
	}

	private WebClient.RequestBodySpec request(TsEndpoint endpoint) {
		return webClient.post()
				.uri(uriBuilder -> uriBuilder.path(endpoint.value())
						.queryParam(TOKEN_QUERY_PARAM, accessToken)
						.build())
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON);
	}
}
