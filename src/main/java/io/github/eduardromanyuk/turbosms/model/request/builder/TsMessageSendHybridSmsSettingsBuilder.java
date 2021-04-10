package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.impl.TsMessageSendSmsRequestImpl;

public class TsMessageSendHybridSmsSettingsBuilder extends TsMessageSendSmsAbstractBuilder<TsMessageSendHybridSmsSettingsBuilder> {
    private final TsMessageSendHybridBuilder parentBuilder;

    TsMessageSendHybridSmsSettingsBuilder(TsMessageSendSmsRequestImpl message, TsMessageSendHybridBuilder parentBuilder) {
        super(message);
        this.parentBuilder = parentBuilder;
    }

    public TsMessageSendHybridBuilder build() {
        parentBuilder.setSms(message);
        return parentBuilder;
    }

    @Override
    protected TsMessageSendHybridSmsSettingsBuilder getBuilder() {
        return this;
    }
}
