package io.github.eduardromanyuk.turbosms.model.request.impl;

import io.github.eduardromanyuk.turbosms.model.request.TsHybridMessage;
import io.github.eduardromanyuk.turbosms.model.request.TsSmsMessage;
import io.github.eduardromanyuk.turbosms.model.request.TsViberMessage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class TsHybridMessageImpl extends TsMessageImpl implements TsHybridMessage {
    private TsSmsMessage sms;
    private TsViberMessage viber;

    public TsHybridMessageImpl(TsSmsMessage settings) {
        this.sms = settings;
    }

    public TsHybridMessageImpl(TsViberMessage settings) {
        this.viber = settings;
    }

    public TsHybridMessageImpl(String sender) {
        this.sender = sender;
    }

    public TsHybridMessageImpl() {}
}
