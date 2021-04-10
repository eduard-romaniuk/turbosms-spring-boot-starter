package io.github.eduardromanyuk.turbosms.configuration;

import io.github.eduardromanyuk.turbosms.property.TsProperties;
import io.github.eduardromanyuk.turbosms.service.TsApiService;
import io.github.eduardromanyuk.turbosms.service.impl.TsApiServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(TsProperties.class)
@ConditionalOnClass(RestTemplate.class)
@ConditionalOnProperty(prefix = "turbosms", name = "token")
public class TsAutoConfiguration {
    private final TsProperties properties;
    private static final String BASE_URL = "https://api.turbosms.ua";

    @Bean
    public TsApiService messageService() {
        return new TsApiServiceImpl(webClient(), properties.getToken());
    }

    private WebClient webClient() {
        return WebClient.builder()
                .baseUrl(BASE_URL)
                .build();
    }
}
