package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.impl.TsSmsMessageImpl;

public abstract class TsSmsMessageAbstractBuilder<B extends TsMessageAbstractBuilder<TsSmsMessageImpl, B>>
        extends TsMessageAbstractBuilder<TsSmsMessageImpl, B> {
    protected TsSmsMessageAbstractBuilder(TsSmsMessageImpl message) {
        super(message);
    }

    public B flash() {
        message.setFlash(true);
        return getBuilder();
    }
}
