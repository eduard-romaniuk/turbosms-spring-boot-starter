package io.github.eduardromanyuk.turbosms.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, of = "messageId")
public class TsMessageSendResponse extends TsResponseStatusBody {
    @JsonProperty("phone")
    private String phone;

    @JsonProperty("message_id")
    private String messageId;
}
