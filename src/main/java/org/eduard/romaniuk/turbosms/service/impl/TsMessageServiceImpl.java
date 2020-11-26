package org.eduard.romaniuk.turbosms.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eduard.romaniuk.turbosms.model.request.TsMessage;
import org.eduard.romaniuk.turbosms.model.response.TsResponse;
import org.eduard.romaniuk.turbosms.service.TsMessageService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class TsMessageServiceImpl implements TsMessageService {
    private final RestTemplate restTemplate;

    @Override
    public Optional<TsResponse> send(TsMessage smsMessage) {
        String url = TsEndpoint.MESSAGE_SEND.value();
        HttpEntity<TsMessage> body = new HttpEntity<>(smsMessage);
        Class<TsResponse> responseType = TsResponse.class;
        ResponseEntity<TsResponse> response = restTemplate.postForEntity(url, body, responseType);
        return Optional.ofNullable(response.getBody());
    }
}
