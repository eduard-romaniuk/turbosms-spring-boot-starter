package org.eduard.romaniuk.turbosms.model.request.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.eduard.romaniuk.turbosms.model.request.TsHybridMessage;
import org.eduard.romaniuk.turbosms.model.request.TsSmsMessage;
import org.eduard.romaniuk.turbosms.model.request.TsViberMessage;

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
