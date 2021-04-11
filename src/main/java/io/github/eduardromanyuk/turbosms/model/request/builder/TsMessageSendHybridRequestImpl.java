package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.TsMessageSendHybridRequest;
import io.github.eduardromanyuk.turbosms.model.request.TsMessageSendSmsRequest;
import io.github.eduardromanyuk.turbosms.model.request.TsMessageSendViberRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@Setter(AccessLevel.PACKAGE)
class TsMessageSendHybridRequestImpl extends TsMessageSendRequestImpl implements TsMessageSendHybridRequest {
    private TsMessageSendSmsRequest sms;
    private TsMessageSendViberRequest viber;

    TsMessageSendHybridRequestImpl(TsMessageSendSmsRequest settings) {
        this.sms = settings;
    }

    TsMessageSendHybridRequestImpl(TsMessageSendViberRequest settings) {
        this.viber = settings;
    }

    TsMessageSendHybridRequestImpl(String sender) {
        this.setSender(sender);
    }

    TsMessageSendHybridRequestImpl() {}
}
