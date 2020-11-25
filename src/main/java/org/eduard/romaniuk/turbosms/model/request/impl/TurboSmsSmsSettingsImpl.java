package org.eduard.romaniuk.turbosms.model.request.impl;

import lombok.Getter;
import lombok.ToString;
import org.eduard.romaniuk.turbosms.model.request.TurboSmsSmsSettings;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
class TurboSmsSmsSettingsImpl implements TurboSmsSmsSettings {
    private List<String> recipients;
    private final String sender;
    private String text;
    private LocalDateTime startTime;
    private boolean flash;

    public TurboSmsSmsSettingsImpl(String sender) {
        this.sender = sender;
    }

    void setRecipients(List<String> recipients) {
        this.recipients = recipients;
    }

    void setText(String text) {
        this.text = text;
    }

    void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    void setFlash(boolean flash) {
        this.flash = flash;
    }
}