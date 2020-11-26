package org.eduard.romaniuk.turbosms.model.request.impl;

import lombok.Getter;
import lombok.ToString;
import org.eduard.romaniuk.turbosms.model.request.TsHybridMessage;
import org.eduard.romaniuk.turbosms.model.request.TsSmsMessage;
import org.eduard.romaniuk.turbosms.model.request.TsViberMessage;

import java.util.List;

@Getter
@ToString
public class TsHybridMessageImpl implements TsHybridMessage {
    private List<String> recipients;
    private String sender;
    private String text;
    private String startTime;
    private TsSmsMessage sms;
    private TsViberMessage viber;

    public TsHybridMessageImpl(TsSmsMessage settings) {
        this.sms = settings;
    }

    public TsHybridMessageImpl(TsViberMessage settings) {
        this.viber = settings;
    }
}
