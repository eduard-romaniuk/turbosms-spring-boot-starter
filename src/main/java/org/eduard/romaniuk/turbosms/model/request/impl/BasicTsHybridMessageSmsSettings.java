package org.eduard.romaniuk.turbosms.model.request.impl;

import org.eduard.romaniuk.turbosms.model.request.TsSmsMessage;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BasicTsHybridMessageSmsSettings {
    private final TsSmsMessageImpl message;
    private final BasicTsHybridMessage hybrid;

    BasicTsHybridMessageSmsSettings(TsSmsMessageImpl message, BasicTsHybridMessage hybrid) {
        this.message = message;
        this.hybrid = hybrid;
    }

    public BasicTsHybridMessageSmsSettings text(String text) {
        message.setText(text);
        return this;
    }

    public BasicTsHybridMessageSmsSettings recipients(List<String> recipients) {
        message.setRecipients(recipients);
        return this;
    }

    public BasicTsHybridMessageSmsSettings recipients(String... recipients) {
        message.setRecipients(Arrays.asList(recipients));
        return this;
    }

    public BasicTsHybridMessageSmsSettings recipient(String recipient) {
        if (message.getRecipients() == null) {
            message.setRecipients(new LinkedList<>());
        }
        message.getRecipients().add(recipient);
        return this;
    }

    public BasicTsHybridMessageSmsSettings startTime(LocalDateTime startTime) {
        message.setStartTime(startTime);
        return this;
    }

    public BasicTsHybridMessageSmsSettings flash() {
        message.setFlash(true);
        return this;
    }

    public BasicTsHybridMessage build() {
        hybrid.setSms(message);
        return hybrid;
    }
}
