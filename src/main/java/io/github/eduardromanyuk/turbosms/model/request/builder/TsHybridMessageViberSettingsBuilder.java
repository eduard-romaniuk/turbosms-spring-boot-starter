package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.impl.TsViberMessageImpl;

public class TsHybridMessageViberSettingsBuilder
        extends TsViberMessageAbstractBuilder<TsHybridMessageViberSettingsBuilder> {
    private final TsHybridMessageBuilder parentBuilder;

    TsHybridMessageViberSettingsBuilder(TsViberMessageImpl message, TsHybridMessageBuilder parentBuilder) {
        super(message);
        this.parentBuilder = parentBuilder;
    }

    public TsHybridMessageBuilder build() {
        parentBuilder.setViber(message);
        return parentBuilder;
    }

    @Override
    protected TsHybridMessageViberSettingsBuilder getBuilder() {
        return this;
    }
}
