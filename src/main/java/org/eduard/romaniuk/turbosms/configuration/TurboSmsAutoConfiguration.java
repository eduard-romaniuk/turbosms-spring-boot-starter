package org.eduard.romaniuk.turbosms.configuration;

import lombok.RequiredArgsConstructor;
import org.eduard.romaniuk.turbosms.property.TurboSmsProperties;
import org.eduard.romaniuk.turbosms.service.TurboSmsMessageService;
import org.eduard.romaniuk.turbosms.service.impl.TurboSmsMessageServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(TurboSmsProperties.class)
@ConditionalOnClass(RestTemplate.class)
@ConditionalOnProperty(prefix = "turbosms", name = "token")
public class TurboSmsAutoConfiguration {
    private final TurboSmsProperties properties;

    @Bean
    public TurboSmsMessageService messageService() {
        return new TurboSmsMessageServiceImpl(restTemplate());
    }

    private RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new RestTemplateAuthorizationInterceptor(properties.getToken()));
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }
}
