package org.eduard.romaniuk.turbosms.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;
import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public interface TurboSmsSmsSettings {
    List<String> getRecipients();

    String getSender();

    String getText();

    @JsonProperty("start_time")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime getStartTime();

    @JsonProperty("is_flash")
    boolean isFlash();
}
