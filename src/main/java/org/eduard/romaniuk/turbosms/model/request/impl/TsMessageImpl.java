package org.eduard.romaniuk.turbosms.model.request.impl;

import lombok.Getter;
import lombok.ToString;
import org.eduard.romaniuk.turbosms.model.request.TsMessage;
import org.eduard.romaniuk.turbosms.model.request.TsSmsSettings;

import java.util.List;

@Getter
@ToString
class TsMessageImpl implements TsMessage {
    private final List<String> recipients = null;
    private final TsSmsSettings sms;

    public TsMessageImpl(TsSmsSettings settings) {
        this.sms = settings;
    }
}
