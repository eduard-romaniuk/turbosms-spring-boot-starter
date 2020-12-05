package io.github.eduardromanyuk.turbosms.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.eduardromanyuk.turbosms.model.request.TsHybridMessage;
import io.github.eduardromanyuk.turbosms.model.request.TsSmsMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import io.github.eduardromanyuk.turbosms.model.request.TsViberMessage;
import io.github.eduardromanyuk.turbosms.model.request.impl.TsHybridMessageImpl;
import io.github.eduardromanyuk.turbosms.model.response.TsResponse;
import io.github.eduardromanyuk.turbosms.service.TsMessageService;
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
        return this.send(new TsHybridMessageImpl(smsMessage));
    }

    @Override
    public Optional<TsResponse> send(TsViberMessage viberMessage) {
        return this.send(new TsHybridMessageImpl(viberMessage));
    }

    @Override
    @SneakyThrows
    public Optional<TsResponse> send(TsHybridMessage hybridMessage) {
        String url = TsEndpoint.MESSAGE_SEND.value();
        HttpEntity<TsHybridMessage> body = new HttpEntity<>(hybridMessage);
        Class<TsResponse> responseType = TsResponse.class;
        log.debug(new ObjectMapper().writeValueAsString(hybridMessage));
        ResponseEntity<TsResponse> response = restTemplate.postForEntity(url, body, responseType);
        return Optional.ofNullable(response.getBody());
    }
}
