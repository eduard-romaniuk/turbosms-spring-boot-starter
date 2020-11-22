package org.eduard.romaniuk.turbosms.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eduard.romaniuk.turbosms.model.TurboSmsResponse;
import org.eduard.romaniuk.turbosms.model.TurboSmsSmsMessage;
import org.eduard.romaniuk.turbosms.service.TurboSmsMessageService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class TurboSmsMessageServiceImpl implements TurboSmsMessageService {
    private final RestTemplate restTemplate;

    public Optional<TurboSmsResponse> send(TurboSmsSmsMessage smsMessage) {
        String url = TurboSmsEndpoint.MESSAGE_SEND.value();
        HttpEntity<TurboSmsSmsMessage> body = new HttpEntity<>(smsMessage);
        Class<TurboSmsResponse> responseType = TurboSmsResponse.class;
        ResponseEntity<TurboSmsResponse> response = restTemplate.postForEntity(url, body, responseType);
        return Optional.ofNullable(response.getBody());
    }
}
