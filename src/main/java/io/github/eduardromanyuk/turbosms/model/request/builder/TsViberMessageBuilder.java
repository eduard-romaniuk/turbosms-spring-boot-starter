package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.impl.TsViberMessageImpl;

public class TsViberMessageBuilder extends TsViberMessageAbstractBuilder<TsViberMessageBuilder> {
    private TsViberMessageBuilder(String sender) {
        super(new TsViberMessageImpl(sender));
    }

    public static TsViberMessageBuilder from(String sender) {
        return new TsViberMessageBuilder(sender);
    }

    @Override
    protected TsViberMessageBuilder getBuilder() {
        return this;
    }

    public TsViberMessageImpl build() {
        return this.message;
    }
}
