package io.github.eduardromanyuk.turbosms.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, of = "messageId")
public final class TsMessageSendResponse extends TsResponseStatus {
    @JsonProperty("phone")
    private final String phone;

    @JsonProperty("message_id")
    private final String messageId;

    public TsMessageSendResponse(int responseCode, String responseStatus, String phone, String messageId) {
        super(responseCode, responseStatus);
        this.phone = phone;
        this.messageId = messageId;
    }
}
