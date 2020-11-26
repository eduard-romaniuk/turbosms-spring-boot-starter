package org.eduard.romaniuk.turbosms.model.request.impl;

import org.eduard.romaniuk.turbosms.model.request.TsMessage;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BasicTsSmsMessage {
    private final TsSmsSettingsImpl settings;

    private BasicTsSmsMessage(String sender) {
        this.settings = new TsSmsSettingsImpl(sender);
    }

    public static BasicTsSmsMessage from(String sender) {
        return new BasicTsSmsMessage(sender);
    }

    public BasicTsSmsMessage text(String text) {
        settings.setText(text);
        return this;
    }

    public BasicTsSmsMessage recipients(List<String> recipients) {
        settings.setRecipients(recipients);
        return this;
    }

    public BasicTsSmsMessage recipients(String... recipients) {
        settings.setRecipients(Arrays.asList(recipients));
        return this;
    }

    public BasicTsSmsMessage recipient(String recipient) {
        if (settings.getRecipients() == null) {
            settings.setRecipients(new LinkedList<>());
        }
        settings.getRecipients().add(recipient);
        return this;
    }

    public BasicTsSmsMessage startTime(LocalDateTime startTime) {
        settings.setStartTime(startTime);
        return this;
    }

    public BasicTsSmsMessage flash(boolean flash) {
        settings.setFlash(flash);
        return this;
    }

    public TsMessage build() {
        return new TsMessageImpl(settings);
    }
}
