package org.eduard.romaniuk.turbosms.model.request.impl;

import lombok.Getter;
import lombok.ToString;
import org.eduard.romaniuk.turbosms.model.request.TsHybridMessage;
import org.eduard.romaniuk.turbosms.model.request.TsSmsMessage;

import java.util.List;

@Getter
@ToString
public class TsHybridMessageImpl implements TsHybridMessage {
    private List<String> recipients;
    private String sender;
    private String text;
    private String startTime;
    private final TsSmsMessage sms;

    public TsHybridMessageImpl(TsSmsMessage settings) {
        this.sms = settings;
    }
}
