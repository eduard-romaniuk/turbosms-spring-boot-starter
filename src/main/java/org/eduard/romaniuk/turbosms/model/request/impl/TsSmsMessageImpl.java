package org.eduard.romaniuk.turbosms.model.request.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.eduard.romaniuk.turbosms.model.request.TsSmsMessage;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
public class TsSmsMessageImpl extends TsMessageImpl implements TsSmsMessage {
    private Boolean flash;

    public TsSmsMessageImpl(String sender) {
        this.sender = sender;
    }

    public TsSmsMessageImpl() {}
}
