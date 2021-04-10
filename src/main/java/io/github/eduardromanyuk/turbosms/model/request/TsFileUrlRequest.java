package io.github.eduardromanyuk.turbosms.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface TsFileUrlRequest {
    @JsonProperty("url")
    String getUrl();
}
