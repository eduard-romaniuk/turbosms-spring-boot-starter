package io.github.eduardromanyuk.turbosms.service.impl;

import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class TsRequestService {
	private final RestTemplate restTemplate;

	TsRequestService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public <T> Optional<T> request(TsEndpoint endpoint, Object body, Class<T> responseType) {
		log.debug(toJson(body));
		ResponseEntity<T> response = restTemplate.postForEntity(endpoint.value(), new HttpEntity<>(body), responseType);
		return Optional.ofNullable(response.getBody());
	}

	public <T> Optional<T> request(TsEndpoint endpoint, Object body, ParameterizedTypeReference<T> responseType) {
		log.debug(toJson(body));
		ResponseEntity<T> response = restTemplate.exchange(endpoint.value(), HttpMethod.POST, new HttpEntity<>(body), responseType);
		return Optional.ofNullable(response.getBody());
	}

	@SneakyThrows
	private String toJson(Object object) {
		return new ObjectMapper().writeValueAsString(object);
	}
}
