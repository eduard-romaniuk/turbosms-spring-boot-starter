package io.github.eduardromanyuk.turbosms.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public interface TsMessage {
    @JsonProperty("recipients")
    List<String> getRecipients();

    @JsonProperty("sender")
    String getSender();

    @JsonProperty("text")
    String getText();

    @JsonProperty("start_time")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime getStartTime();
}
