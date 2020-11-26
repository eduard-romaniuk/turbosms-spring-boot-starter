package org.eduard.romaniuk.turbosms.configuration;

import lombok.RequiredArgsConstructor;
import org.eduard.romaniuk.turbosms.property.TsProperties;
import org.eduard.romaniuk.turbosms.service.TsMessageService;
import org.eduard.romaniuk.turbosms.service.impl.TsMessageServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(TsProperties.class)
@ConditionalOnClass(RestTemplate.class)
@ConditionalOnProperty(prefix = "turbosms", name = "token")
public class TsAutoConfiguration {
    private final TsProperties properties;
    private static final String BASE_URL = "https://api.turbosms.ua";

    @Bean
    public TsMessageService messageService() {
        return new TsMessageServiceImpl(restTemplate());
    }

    private RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplateBuilder().rootUri(BASE_URL).build();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new RestTemplateAuthorizationInterceptor(properties.getToken()));
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
