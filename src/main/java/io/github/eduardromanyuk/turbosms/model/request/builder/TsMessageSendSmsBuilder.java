package io.github.eduardromanyuk.turbosms.model.request.builder;

public class TsMessageSendSmsBuilder extends TsMessageSendSmsAbstractBuilder<TsMessageSendSmsBuilder> {
    private TsMessageSendSmsBuilder(String sender) {
        super(new TsMessageSendSmsRequestImpl(sender));
    }

    public static TsMessageSendSmsBuilder from(String sender) {
        return new TsMessageSendSmsBuilder(sender);
    }

    @Override
    protected TsMessageSendSmsBuilder getBuilder() {
        return this;
    }

    public TsMessageSendSmsRequestImpl build() {
        return this.message;
    }
}
