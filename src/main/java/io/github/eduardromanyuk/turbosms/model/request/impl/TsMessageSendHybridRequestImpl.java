package io.github.eduardromanyuk.turbosms.model.request.impl;

import io.github.eduardromanyuk.turbosms.model.request.TsMessageSendHybridRequest;
import io.github.eduardromanyuk.turbosms.model.request.TsMessageSendSmsRequest;
import io.github.eduardromanyuk.turbosms.model.request.TsMessageSendViberMessage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class TsMessageSendHybridRequestImpl extends TsMessageSendRequestImpl implements TsMessageSendHybridRequest {
    private TsMessageSendSmsRequest sms;
    private TsMessageSendViberMessage viber;

    public TsMessageSendHybridRequestImpl(TsMessageSendSmsRequest settings) {
        this.sms = settings;
    }

    public TsMessageSendHybridRequestImpl(TsMessageSendViberMessage settings) {
        this.viber = settings;
    }

    public TsMessageSendHybridRequestImpl(String sender) {
        this.setSender(sender);
    }

    public TsMessageSendHybridRequestImpl() {}
}
