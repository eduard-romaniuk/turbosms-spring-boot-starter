package org.eduard.romaniuk.turbosms.model.request.impl;

import lombok.Getter;
import lombok.ToString;
import org.eduard.romaniuk.turbosms.model.request.TurboSmsMessage;
import org.eduard.romaniuk.turbosms.model.request.TurboSmsSmsSettings;

import java.util.List;

@Getter
@ToString
class TurboSmsSmsMessageImpl implements TurboSmsMessage {
    private final List<String> recipients = null;
    private final TurboSmsSmsSettings sms;

    public TurboSmsSmsMessageImpl(TurboSmsSmsSettings settings) {
        this.sms = settings;
    }
}
