package org.eduard.romaniuk.turbosms.model.request.impl;

import org.eduard.romaniuk.turbosms.model.request.TsHybridMessage;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BasicTsHybridMessage {
    private final TsHybridMessageImpl hybrid;
    private TsSmsMessageImpl sms;
    private TsViberMessageImpl viber;

    private BasicTsHybridMessage(String sender) {
        this.hybrid = new TsHybridMessageImpl(sender);
    }

    private BasicTsHybridMessage(String smsSender, String viberSender) {
        this.hybrid = new TsHybridMessageImpl();
        this.sms = new TsSmsMessageImpl(smsSender);
        this.viber = new TsViberMessageImpl(viberSender);
    }

    public static BasicTsHybridMessage from(String sender) {
        return new BasicTsHybridMessage(sender);
    }

    public static BasicTsHybridMessage from(String smsSender, String viberSender) {
        return new BasicTsHybridMessage(smsSender, viberSender);
    }

    public BasicTsHybridMessage text(String text) {
        hybrid.setText(text);
        return this;
    }

    public BasicTsHybridMessage recipients(List<String> recipients) {
        hybrid.setRecipients(recipients);
        return this;
    }

    public BasicTsHybridMessage recipients(String... recipients) {
        hybrid.setRecipients(Arrays.asList(recipients));
        return this;
    }

    public BasicTsHybridMessage recipient(String recipient) {
        if (hybrid.getRecipients() == null) {
            hybrid.setRecipients(new LinkedList<>());
        }
        hybrid.getRecipients().add(recipient);
        return this;
    }

    public BasicTsHybridMessage startTime(LocalDateTime startTime) {
        hybrid.setStartTime(startTime);
        return this;
    }

    public BasicTsHybridMessageSmsSettings smsSettings() {
        if (sms == null) {
            this.sms = new TsSmsMessageImpl();
        }
        return new BasicTsHybridMessageSmsSettings(sms, this);
    }

    public BasicTsHybridMessageViberSettings viberSettings() {
        if (viber == null) {
            this.viber = new TsViberMessageImpl();
        }
        return new BasicTsHybridMessageViberSettings(viber, this);
    }

    public TsHybridMessage build() {
        if (sms != null) {
            hybrid.setSms(sms);
        }
        if (viber != null) {
            hybrid.setViber(viber);
        }
        return hybrid;
    }

    void setSms(TsSmsMessageImpl sms) {
        this.sms = sms;
    }

    void setViber(TsViberMessageImpl viber) {
        this.viber = viber;
    }
}
