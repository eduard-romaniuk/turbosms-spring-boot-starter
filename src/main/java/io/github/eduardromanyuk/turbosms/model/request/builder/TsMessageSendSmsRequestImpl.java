package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.TsMessageSendSmsRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@Setter(AccessLevel.PACKAGE)
public class TsMessageSendSmsRequestImpl extends TsMessageSendRequestImpl implements TsMessageSendSmsRequest {
    private Boolean flash;

    TsMessageSendSmsRequestImpl(String sender) {
        this.setSender(sender);
    }

    TsMessageSendSmsRequestImpl() {}
}
