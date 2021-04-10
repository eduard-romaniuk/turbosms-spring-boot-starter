package io.github.eduardromanyuk.turbosms.model.request.impl;

import io.github.eduardromanyuk.turbosms.model.request.TsMessageSendSmsRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class TsMessageSendSmsRequestImpl extends TsMessageSendRequestImpl implements TsMessageSendSmsRequest {
    private Boolean flash;

    public TsMessageSendSmsRequestImpl(String sender) {
        this.setSender(sender);
    }

    public TsMessageSendSmsRequestImpl() {}
}
