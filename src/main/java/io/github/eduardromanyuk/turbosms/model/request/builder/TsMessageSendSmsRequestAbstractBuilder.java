package io.github.eduardromanyuk.turbosms.model.request.builder;

public abstract class TsMessageSendSmsRequestAbstractBuilder<B extends TsMessageSendRequestAbstractBuilder<TsMessageSendSmsRequestImpl, B>>
        extends TsMessageSendRequestAbstractBuilder<TsMessageSendSmsRequestImpl, B> {
    protected TsMessageSendSmsRequestAbstractBuilder(TsMessageSendSmsRequestImpl message) {
        super(message);
    }

    public B flash() {
        message.setFlash(true);
        return getBuilder();
    }
}
