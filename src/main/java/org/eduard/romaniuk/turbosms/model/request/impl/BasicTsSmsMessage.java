package org.eduard.romaniuk.turbosms.model.request.impl;

import org.eduard.romaniuk.turbosms.model.request.TsSmsMessage;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BasicTsSmsMessage {
    private final TsSmsMessageImpl message;

    private BasicTsSmsMessage(String sender) {
        this.message = new TsSmsMessageImpl(sender);
    }

    public static BasicTsSmsMessage from(String sender) {
        return new BasicTsSmsMessage(sender);
    }

    public BasicTsSmsMessage text(String text) {
        message.setText(text);
        return this;
    }

    public BasicTsSmsMessage recipients(List<String> recipients) {
        message.setRecipients(recipients);
        return this;
    }

    public BasicTsSmsMessage recipients(String... recipients) {
        message.setRecipients(Arrays.asList(recipients));
        return this;
    }

    public BasicTsSmsMessage recipient(String recipient) {
        if (message.getRecipients() == null) {
            message.setRecipients(new LinkedList<>());
        }
        message.getRecipients().add(recipient);
        return this;
    }

    public BasicTsSmsMessage startTime(LocalDateTime startTime) {
        message.setStartTime(startTime);
        return this;
    }

    public BasicTsSmsMessage flash(boolean flash) {
        message.setFlash(flash);
        return this;
    }

    public TsSmsMessage build() {
        return message;
    }
}
