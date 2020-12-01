package org.eduard.romaniuk.turbosms.model.request.builder;

import org.eduard.romaniuk.turbosms.model.request.impl.TsSmsMessageImpl;

public class TsSmsMessageBuilder extends TsSmsMessageAbstractBuilder<TsSmsMessageBuilder> {
    private TsSmsMessageBuilder(String sender) {
        super(new TsSmsMessageImpl(sender));
    }

    public static TsSmsMessageBuilder from(String sender) {
        return new TsSmsMessageBuilder(sender);
    }

    @Override
    protected TsSmsMessageBuilder getBuilder() {
        return this;
    }

    public TsSmsMessageImpl build() {
        return this.message;
    }
}
