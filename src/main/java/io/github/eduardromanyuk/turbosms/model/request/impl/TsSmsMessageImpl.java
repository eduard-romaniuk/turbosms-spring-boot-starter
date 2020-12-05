package io.github.eduardromanyuk.turbosms.model.request.impl;

import io.github.eduardromanyuk.turbosms.model.request.TsSmsMessage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
