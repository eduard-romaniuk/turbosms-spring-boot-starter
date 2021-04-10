package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.impl.TsMessageSendSmsRequestImpl;

public abstract class TsMessageSendSmsAbstractBuilder<B extends TsMessageSendAbstractBuilder<TsMessageSendSmsRequestImpl, B>>
        extends TsMessageSendAbstractBuilder<TsMessageSendSmsRequestImpl, B> {
    protected TsMessageSendSmsAbstractBuilder(TsMessageSendSmsRequestImpl message) {
        super(message);
    }

    public B flash() {
        message.setFlash(true);
        return getBuilder();
    }
}
