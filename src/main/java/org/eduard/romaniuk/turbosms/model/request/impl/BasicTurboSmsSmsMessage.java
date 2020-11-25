package org.eduard.romaniuk.turbosms.model.request.impl;

import org.eduard.romaniuk.turbosms.model.request.TurboSmsMessage;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BasicTurboSmsSmsMessage {
    private final TurboSmsSmsSettingsImpl settings;

    private BasicTurboSmsSmsMessage(String sender) {
        this.settings = new TurboSmsSmsSettingsImpl(sender);
    }

    public static BasicTurboSmsSmsMessage from(String sender) {
        return new BasicTurboSmsSmsMessage(sender);
    }

    public BasicTurboSmsSmsMessage text(String text) {
        settings.setText(text);
        return this;
    }

    public BasicTurboSmsSmsMessage recipients(List<String> recipients) {
        settings.setRecipients(recipients);
        return this;
    }

    public BasicTurboSmsSmsMessage recipients(String... recipients) {
        settings.setRecipients(Arrays.asList(recipients));
        return this;
    }

    public BasicTurboSmsSmsMessage recipient(String recipient) {
        if (settings.getRecipients() == null) {
            settings.setRecipients(new LinkedList<>());
        }
        settings.getRecipients().add(recipient);
        return this;
    }

    public BasicTurboSmsSmsMessage startTime(LocalDateTime startTime) {
        settings.setStartTime(startTime);
        return this;
    }

    public BasicTurboSmsSmsMessage flash(boolean flash) {
        settings.setFlash(flash);
        return this;
    }

    public TurboSmsMessage build() {
        return new TurboSmsSmsMessageImpl(settings);
    }
}
