package org.eduard.romaniuk.turbosms.model.request.builder;

import org.eduard.romaniuk.turbosms.model.request.impl.TsViberMessageImpl;

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
