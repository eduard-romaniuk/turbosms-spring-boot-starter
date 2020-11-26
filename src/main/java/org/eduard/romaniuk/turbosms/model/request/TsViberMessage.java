package org.eduard.romaniuk.turbosms.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public interface TsViberMessage extends TsMessage {
    int getTtl();

    @JsonProperty("image_url")
    String getImageUrl();

    String getCaption();

    String getAction();

    @JsonProperty("count_clicks")
    boolean getCountClicks();

    @JsonProperty("is_transactional")
    boolean isTransactional();
}
