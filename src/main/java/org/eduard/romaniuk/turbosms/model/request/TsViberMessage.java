package org.eduard.romaniuk.turbosms.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public interface TsViberMessage extends TsMessage {
    @JsonProperty("ttl")
    int getTtl();

    @JsonProperty("image_url")
    String getImageUrl();

    @JsonProperty("caption")
    String getCaption();

    @JsonProperty("action")
    String getAction();

    @JsonProperty("count_clicks")
    boolean getCountClicks();

    @JsonProperty("is_transactional")
    boolean isTransactional();
}
