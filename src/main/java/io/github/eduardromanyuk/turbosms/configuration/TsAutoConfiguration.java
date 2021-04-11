package io.github.eduardromanyuk.turbosms.configuration;

import io.github.eduardromanyuk.turbosms.property.TsProperties;
import io.github.eduardromanyuk.turbosms.service.TsApiService;
import io.github.eduardromanyuk.turbosms.service.impl.TsApiServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
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
    public TsApiService messageService() {
        return new TsApiServiceImpl(restTemplate());
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

    @RequiredArgsConstructor
    public static class RestTemplateAuthorizationInterceptor implements ClientHttpRequestInterceptor {
        private final String token;

        public ClientHttpResponse intercept(
                HttpRequest request,
                byte[] body,
                ClientHttpRequestExecution execution) throws IOException {
            URI uri = UriComponentsBuilder.fromHttpRequest(request)
                    .queryParam("token", token)
                    .build().toUri();

            HttpRequest modifiedRequest = new HttpRequestWrapper(request) {
                @Override
                public URI getURI() {
                    return uri;
                }
            };

            return execution.execute(modifiedRequest, body);
        }
    }
}
