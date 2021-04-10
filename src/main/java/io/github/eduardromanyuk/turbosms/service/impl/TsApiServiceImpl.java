package io.github.eduardromanyuk.turbosms.service.impl;

import io.github.eduardromanyuk.turbosms.model.request.*;
import io.github.eduardromanyuk.turbosms.model.request.impl.TsMessageSendHybridRequestImpl;
import io.github.eduardromanyuk.turbosms.model.response.*;
import io.github.eduardromanyuk.turbosms.service.TsApiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Slf4j
public class TsApiServiceImpl implements TsApiService {
	private static final String EMPTY = "";
	private final TsRequestService requestService;

	public TsApiServiceImpl(WebClient webClient) {
		this.requestService = new TsRequestService(webClient);
	}

	@Override
	public Mono<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendSmsRequest smsMessage) {
		return this.messageSend(new TsMessageSendHybridRequestImpl(smsMessage));
	}

	@Override
	public Mono<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendViberMessage viberMessage) {
		return this.messageSend(new TsMessageSendHybridRequestImpl(viberMessage));
	}

	@Override
	public Mono<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendHybridRequest hybridMessage) {
		return requestService.request(
				TsEndpoint.MESSAGE_SEND,
				hybridMessage,
				new ParameterizedTypeReference<TsResponseWrapper<List<TsMessageSendResponse>>>() {}
		);
	}

	@Override
	public Mono<TsResponseWrapper<List<TsMessageStatusResponse>>> messageStatus(TsMessageStatusRequest statusRequest) {
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
	public Mono<TsResponseWrapper<TsUserBalanceResponse>> userBalance() {
		return requestService.request(
				TsEndpoint.USER_BALANCE,
				new ParameterizedTypeReference<TsResponseWrapper<TsUserBalanceResponse>>() {}
		);
	}

	@Override
	public Mono<TsResponseWrapper<TsFileAddResponse>> fileAdd(TsFileAddUrlRequest urlRequest) {
		if (urlRequest.getUrl() == null || EMPTY.equals(urlRequest.getUrl().trim())) {
			throw new IllegalArgumentException("url field cannot be null or empty");
		}
		return requestService.request(
				TsEndpoint.FILE_ADD,
				urlRequest,
				new ParameterizedTypeReference<TsResponseWrapper<TsFileAddResponse>>() {}
		);
	}

	@Override
	public Mono<TsResponseWrapper<TsFileAddResponse>> fileAdd(TsFileAddDataRequest dataRequest) {
		if (dataRequest.getData() == null || EMPTY.equals(dataRequest.getData().trim())) {
			throw new IllegalArgumentException("data field cannot be null or empty");
		}
		return requestService.request(
				TsEndpoint.FILE_ADD,
				dataRequest,
				new ParameterizedTypeReference<TsResponseWrapper<TsFileAddResponse>>() {}
		);
	}

	@Override
	public Mono<TsResponseWrapper<TsFileAddResponse>> fileDetails(long id) {
		if (id < 1) {
			throw new IllegalArgumentException("id cannot be less than 1");
		}
		return requestService.request(
				TsEndpoint.FILE_DETAILS,
				Collections.singletonMap("id", id),
				new ParameterizedTypeReference<TsResponseWrapper<TsFileAddResponse>>() {}
		);
	}

	private Mono<TsResponseWrapper<List<TsMessageStatusResponse>>> messageStatusEmptyResponse() {
		return Mono.just(new TsResponseWrapper<>(0, "OK", Collections.emptyList()));
	}
}
