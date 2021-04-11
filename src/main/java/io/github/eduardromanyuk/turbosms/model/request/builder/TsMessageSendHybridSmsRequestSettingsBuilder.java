package io.github.eduardromanyuk.turbosms.model.request.builder;

public class TsMessageSendHybridSmsRequestSettingsBuilder extends TsMessageSendSmsRequestAbstractBuilder<TsMessageSendHybridSmsRequestSettingsBuilder> {
    private final TsMessageSendHybridRequestBuilder parentBuilder;

    TsMessageSendHybridSmsRequestSettingsBuilder(TsMessageSendSmsRequestImpl message, TsMessageSendHybridRequestBuilder parentBuilder) {
        super(message);
        this.parentBuilder = parentBuilder;
    }

    public TsMessageSendHybridRequestBuilder build() {
        parentBuilder.setSms(message);
        return parentBuilder;
    }

    @Override
    protected TsMessageSendHybridSmsRequestSettingsBuilder getBuilder() {
        return this;
    }
}
