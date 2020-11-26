package org.eduard.romaniuk.turbosms.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eduard.romaniuk.turbosms.model.request.TsHybridMessage;
import org.eduard.romaniuk.turbosms.model.request.TsSmsMessage;
import org.eduard.romaniuk.turbosms.model.request.impl.TsHybridMessageImpl;
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
    public Optional<TsResponse> send(TsSmsMessage smsMessage) {
        String url = TsEndpoint.MESSAGE_SEND.value();
        TsHybridMessageImpl message = new TsHybridMessageImpl(smsMessage);
        HttpEntity<TsHybridMessage> body = new HttpEntity<>(message);
        Class<TsResponse> responseType = TsResponse.class;
        ResponseEntity<TsResponse> response = restTemplate.postForEntity(url, body, responseType);
        return Optional.ofNullable(response.getBody());
    }
}
