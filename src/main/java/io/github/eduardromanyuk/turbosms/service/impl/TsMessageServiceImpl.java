package io.github.eduardromanyuk.turbosms.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestTemplate;

import io.github.eduardromanyuk.turbosms.model.request.TsHybridMessage;
import io.github.eduardromanyuk.turbosms.model.request.TsMessageStatusRequest;
import io.github.eduardromanyuk.turbosms.model.request.TsSmsMessage;
import io.github.eduardromanyuk.turbosms.model.request.TsViberMessage;
import io.github.eduardromanyuk.turbosms.model.request.impl.TsHybridMessageImpl;
import io.github.eduardromanyuk.turbosms.model.response.TsBalanceResponse;
import io.github.eduardromanyuk.turbosms.model.response.TsMessageStatusResponse;
import io.github.eduardromanyuk.turbosms.model.response.TsResponse;
import io.github.eduardromanyuk.turbosms.model.response.TsResponseWrapper;
import io.github.eduardromanyuk.turbosms.service.TsMessageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TsMessageServiceImpl implements TsMessageService {
	private final TsRequestService requestService;

	public TsMessageServiceImpl(RestTemplate restTemplate) {
		this.requestService = new TsRequestService(restTemplate);
	}

	@Override
	public Optional<TsResponse> send(TsSmsMessage smsMessage) {
		return this.send(new TsHybridMessageImpl(smsMessage));
	}

	@Override
	public Optional<TsResponse> send(TsViberMessage viberMessage) {
		return this.send(new TsHybridMessageImpl(viberMessage));
	}

	@Override
	public Optional<TsResponse> send(TsHybridMessage hybridMessage) {
		return requestService.request(TsEndpoint.MESSAGE_SEND, hybridMessage, TsResponse.class);
	}

	@Override
	public Optional<TsResponseWrapper<List<TsMessageStatusResponse>>> status(TsMessageStatusRequest statusRequest) {
		if (statusRequest.messages() == null) {
			throw new IllegalArgumentException("messages field cannot be null");
		}
		if (statusRequest.messages().isEmpty()) {
			return messageStatusEmptyResponse();
		}
		return requestService.request(
				TsEndpoint.MESSAGE_STATUS,
				statusRequest,
				new ParameterizedTypeReference<TsResponseWrapper<List<TsMessageStatusResponse>>>() {}
		);
	}

	@Override
	public Optional<TsResponseWrapper<TsBalanceResponse>> balance() {
		return requestService.request(
				TsEndpoint.USER_BALANCE,
				new ParameterizedTypeReference<TsResponseWrapper<TsBalanceResponse>>() {}
		);
	}

	private Optional<TsResponseWrapper<List<TsMessageStatusResponse>>> messageStatusEmptyResponse() {
		TsResponseWrapper<List<TsMessageStatusResponse>> response = new TsResponseWrapper<>();
		response.setResponse_code(0);
		response.setResponse_status("OK");
		response.setResponse_result(Collections.emptyList());
		return Optional.of(response);
	}
}
