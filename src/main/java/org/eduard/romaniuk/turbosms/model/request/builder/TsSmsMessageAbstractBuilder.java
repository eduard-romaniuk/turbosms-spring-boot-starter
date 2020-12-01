package org.eduard.romaniuk.turbosms.model.request.builder;

import org.eduard.romaniuk.turbosms.model.request.impl.TsSmsMessageImpl;

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
