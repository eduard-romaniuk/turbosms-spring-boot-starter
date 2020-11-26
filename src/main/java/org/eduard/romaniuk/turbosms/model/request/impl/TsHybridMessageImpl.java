package org.eduard.romaniuk.turbosms.model.request.impl;

import lombok.Getter;
import lombok.ToString;
import org.eduard.romaniuk.turbosms.model.request.TsHybridMessage;
import org.eduard.romaniuk.turbosms.model.request.TsSmsMessage;
import org.eduard.romaniuk.turbosms.model.request.TsViberMessage;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
public class TsHybridMessageImpl implements TsHybridMessage {
    private List<String> recipients;
    private String sender;
    private String text;
    private LocalDateTime startTime;
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

    TsHybridMessageImpl() {}

    void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    void setSender(String sender) {
        this.sender = sender;
    }

    void setText(String text) {
        this.text = text;
    }

    void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    void setSms(TsSmsMessage sms) {
        this.sms = sms;
    }

    void setViber(TsViberMessage viber) {
        this.viber = viber;
    }
}
