package io.github.eduardromanyuk.turbosms.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import io.github.eduardromanyuk.turbosms.model.request.*;
import io.github.eduardromanyuk.turbosms.model.response.*;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestTemplate;

import io.github.eduardromanyuk.turbosms.model.request.impl.TsHybridMessageImpl;
import io.github.eduardromanyuk.turbosms.service.TsMessageService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TsMessageServiceImpl implements TsMessageService {
	private static final String EMPTY = "";
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
		if (statusRequest.getMessages() == null) {
			throw new IllegalArgumentException("messages field cannot be null");
		}
		if (statusRequest.getMessages().isEmpty()) {
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

	@Override
	public Optional<TsResponseWrapper<TsFileResponse>> fileAdd(TsFileUrlRequest urlRequest) {
		if (urlRequest.getUrl() == null || EMPTY.equals(urlRequest.getUrl().trim())) {
			throw new IllegalArgumentException("url field cannot be null or empty");
		}
		return requestService.request(
				TsEndpoint.FILE_ADD,
				urlRequest,
				new ParameterizedTypeReference<TsResponseWrapper<TsFileResponse>>() {}
		);
	}

	@Override
	public Optional<TsResponseWrapper<TsFileResponse>> fileAdd(TsFileDataRequest dataRequest) {
		if (dataRequest.getData() == null || EMPTY.equals(dataRequest.getData().trim())) {
			throw new IllegalArgumentException("data field cannot be null or empty");
		}
		return requestService.request(
				TsEndpoint.FILE_ADD,
				dataRequest,
				new ParameterizedTypeReference<TsResponseWrapper<TsFileResponse>>() {}
		);
	}

	@Override
	public Optional<TsResponseWrapper<TsFileResponse>> fileDetails(long id) {
		if (id < 1) {
			throw new IllegalArgumentException("id cannot be less than 1");
		}
		return requestService.request(
				TsEndpoint.FILE_DETAILS,
				Collections.singletonMap("id", id),
				new ParameterizedTypeReference<TsResponseWrapper<TsFileResponse>>() {}
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
