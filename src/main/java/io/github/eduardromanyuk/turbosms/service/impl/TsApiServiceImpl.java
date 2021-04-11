package io.github.eduardromanyuk.turbosms.service.impl;

import io.github.eduardromanyuk.turbosms.model.request.*;
import io.github.eduardromanyuk.turbosms.model.response.*;
import io.github.eduardromanyuk.turbosms.service.TsApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
public class TsApiServiceImpl implements TsApiService {
	private final RestTemplate restTemplate;

	@Override
	public ResponseEntity<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendSmsRequest smsMessage) {
		return request(
				TsEndpoint.MESSAGE_SEND,
				Collections.singletonMap("sms", smsMessage),
				new ParameterizedTypeReference<TsResponseWrapper<List<TsMessageSendResponse>>>() {}
		);
	}

	@Override
	public ResponseEntity<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendViberRequest viberMessage) {
		return request(
				TsEndpoint.MESSAGE_SEND,
				Collections.singletonMap("viber", viberMessage),
				new ParameterizedTypeReference<TsResponseWrapper<List<TsMessageSendResponse>>>() {}
		);
	}

	@Override
	public ResponseEntity<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendHybridRequest hybridMessage) {
		return request(
				TsEndpoint.MESSAGE_SEND,
				hybridMessage,
				new ParameterizedTypeReference<TsResponseWrapper<List<TsMessageSendResponse>>>() {}
		);
	}

	@Override
	public ResponseEntity<TsResponseWrapper<List<TsMessageStatusResponse>>> messageStatus(TsMessageStatusRequest statusRequest) {
		return request(
				TsEndpoint.MESSAGE_STATUS,
				statusRequest,
				new ParameterizedTypeReference<TsResponseWrapper<List<TsMessageStatusResponse>>>() {}
		);
	}

	@Override
	public ResponseEntity<TsResponseWrapper<TsUserBalanceResponse>> userBalance() {
		return request(
				TsEndpoint.USER_BALANCE,
				new ParameterizedTypeReference<TsResponseWrapper<TsUserBalanceResponse>>() {}
		);
	}

	@Override
	public ResponseEntity<TsResponseWrapper<TsFileAddResponse>> fileAdd(TsFileAddUrlRequest urlRequest) {
		return request(
				TsEndpoint.FILE_ADD,
				urlRequest,
				new ParameterizedTypeReference<TsResponseWrapper<TsFileAddResponse>>() {}
		);
	}

	@Override
	public ResponseEntity<TsResponseWrapper<TsFileAddResponse>> fileAdd(TsFileAddDataRequest dataRequest) {
		return request(
				TsEndpoint.FILE_ADD,
				dataRequest,
				new ParameterizedTypeReference<TsResponseWrapper<TsFileAddResponse>>() {}
		);
	}

	@Override
	public ResponseEntity<TsResponseWrapper<TsFileAddResponse>> fileDetails(TsFileDetailsRequest detailsRequest) {
		return request(
				TsEndpoint.FILE_DETAILS,
				detailsRequest,
				new ParameterizedTypeReference<TsResponseWrapper<TsFileAddResponse>>() {}
		);
	}

	private <T> ResponseEntity<T> request(TsEndpoint endpoint, Object body, ParameterizedTypeReference<T> responseType) {
		return restTemplate.exchange(endpoint.value(), HttpMethod.POST, new HttpEntity<>(body), responseType);
	}

	private <T> ResponseEntity<T> request(TsEndpoint endpoint, ParameterizedTypeReference<T> responseType) {
		return restTemplate.exchange(endpoint.value(), HttpMethod.POST, HttpEntity.EMPTY, responseType);
	}
}
