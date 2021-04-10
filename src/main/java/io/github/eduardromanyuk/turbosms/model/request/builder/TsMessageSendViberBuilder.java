package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.impl.TsMessageSendViberMessageImpl;

public class TsMessageSendViberBuilder extends TsMessageSendViberAbstractBuilder<TsMessageSendViberBuilder> {
    private TsMessageSendViberBuilder(String sender) {
        super(new TsMessageSendViberMessageImpl(sender));
    }

    public static TsMessageSendViberBuilder from(String sender) {
        return new TsMessageSendViberBuilder(sender);
    }

    @Override
    protected TsMessageSendViberBuilder getBuilder() {
        return this;
    }

    public TsMessageSendViberMessageImpl build() {
        return this.message;
    }
}
