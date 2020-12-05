package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.impl.TsSmsMessageImpl;

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
