package io.github.eduardromanyuk.turbosms.model.request.builder;

public class TsMessageSendHybridViberRequestSettingsBuilder
        extends TsMessageSendViberRequestAbstractBuilder<TsMessageSendHybridViberRequestSettingsBuilder> {
    private final TsMessageSendHybridRequestBuilder parentBuilder;

    TsMessageSendHybridViberRequestSettingsBuilder(TsMessageSendViberRequestImpl message, TsMessageSendHybridRequestBuilder parentBuilder) {
        super(message);
        this.parentBuilder = parentBuilder;
    }

    public TsMessageSendHybridRequestBuilder build() {
        parentBuilder.setViber(message);
        return parentBuilder;
    }

    @Override
    protected TsMessageSendHybridViberRequestSettingsBuilder getBuilder() {
        return this;
    }
}
