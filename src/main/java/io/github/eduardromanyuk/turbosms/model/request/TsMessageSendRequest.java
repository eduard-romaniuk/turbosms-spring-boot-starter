package io.github.eduardromanyuk.turbosms.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eduardromanyuk.turbosms.json.JsonLocalDateTime;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public interface TsMessageSendRequest {
    @JsonProperty("recipients")
    List<String> getRecipients();

    @JsonProperty("sender")
    String getSender();

    @JsonProperty("text")
    String getText();

    @JsonLocalDateTime
    @JsonProperty("start_time")
    LocalDateTime getStartTime();
}
