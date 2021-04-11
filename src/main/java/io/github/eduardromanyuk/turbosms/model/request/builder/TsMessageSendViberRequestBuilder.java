package io.github.eduardromanyuk.turbosms.model.request.builder;

public class TsMessageSendViberRequestBuilder extends TsMessageSendViberRequestAbstractBuilder<TsMessageSendViberRequestBuilder> {
    private TsMessageSendViberRequestBuilder(String sender) {
        super(new TsMessageSendViberRequestImpl(sender));
    }

    public static TsMessageSendViberRequestBuilder from(String sender) {
        return new TsMessageSendViberRequestBuilder(sender);
    }

    @Override
    protected TsMessageSendViberRequestBuilder getBuilder() {
        return this;
    }

    public TsMessageSendViberRequestImpl build() {
        return this.message;
    }
}
