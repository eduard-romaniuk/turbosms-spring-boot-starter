package io.github.eduardromanyuk.turbosms.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("turbosms")
public class TsProperties {
    /**
     * Turbo SMS http api token
     */
    private String token;
}
