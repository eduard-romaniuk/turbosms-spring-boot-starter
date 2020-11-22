package org.eduard.romaniuk.turbosms.configuration;

import lombok.RequiredArgsConstructor;
import org.eduard.romaniuk.turbosms.property.TurboSmsProperties;
import org.eduard.romaniuk.turbosms.service.PingService;
import org.eduard.romaniuk.turbosms.service.impl.PingServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(TurboSmsProperties.class)
@ConditionalOnProperty(prefix = "turbosms", name = "token")
public class TurboSmsAutoConfiguration {
    private final TurboSmsProperties properties;

    @Bean
    public PingService pingService() {
        return new PingServiceImpl(properties.getToken());
    }
}
