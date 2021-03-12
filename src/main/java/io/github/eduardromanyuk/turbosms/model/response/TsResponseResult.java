package io.github.eduardromanyuk.turbosms.model.response;

import java.util.Optional;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class TsResponseResult extends TsResponseStatus{
    private String phone;
    private String message_id;

    public Optional<String> getMessageIdOptional() {
    	return Optional.ofNullable(message_id);
    }
}
