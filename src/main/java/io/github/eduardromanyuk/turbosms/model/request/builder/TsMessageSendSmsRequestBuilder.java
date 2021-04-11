package io.github.eduardromanyuk.turbosms.model.request.builder;

public class TsMessageSendSmsRequestBuilder extends TsMessageSendSmsRequestAbstractBuilder<TsMessageSendSmsRequestBuilder> {
    private TsMessageSendSmsRequestBuilder(String sender) {
        super(new TsMessageSendSmsRequestImpl(sender));
    }

    public static TsMessageSendSmsRequestBuilder from(String sender) {
        return new TsMessageSendSmsRequestBuilder(sender);
    }

    @Override
    protected TsMessageSendSmsRequestBuilder getBuilder() {
        return this;
    }

    public TsMessageSendSmsRequestImpl build() {
        return this.message;
    }
}
