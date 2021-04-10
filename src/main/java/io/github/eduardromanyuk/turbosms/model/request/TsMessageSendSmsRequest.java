package io.github.eduardromanyuk.turbosms.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public interface TsMessageSendSmsRequest extends TsMessageSendRequest {
    @JsonProperty("is_flash")
    Boolean getFlash();
}
