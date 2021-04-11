package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.TsMessageSendHybridRequest;

public class TsMessageSendHybridRequestBuilder extends TsMessageSendRequestAbstractBuilder<TsMessageSendHybridRequestImpl, TsMessageSendHybridRequestBuilder> {
    private TsMessageSendSmsRequestImpl sms;
    private TsMessageSendViberRequestImpl viber;

    private TsMessageSendHybridRequestBuilder(String sender) {
        super(new TsMessageSendHybridRequestImpl(sender));
        this.sms = new TsMessageSendSmsRequestImpl();
        this.viber = new TsMessageSendViberRequestImpl();
    }

    private TsMessageSendHybridRequestBuilder(String smsSender, String viberSender) {
        super(new TsMessageSendHybridRequestImpl());
        this.sms = new TsMessageSendSmsRequestImpl(smsSender);
        this.viber = new TsMessageSendViberRequestImpl(viberSender);
    }

    public static TsMessageSendHybridRequestBuilder from(String sender) {
        return new TsMessageSendHybridRequestBuilder(sender);
    }

    public static TsMessageSendHybridRequestBuilder from(String smsSender, String viberSender) {
        return new TsMessageSendHybridRequestBuilder(smsSender, viberSender);
    }

    public TsMessageSendHybridSmsRequestSettingsBuilder smsSettings() {
        return new TsMessageSendHybridSmsRequestSettingsBuilder(sms, this);
    }

    public TsMessageSendHybridViberRequestSettingsBuilder viberSettings() {
        return new TsMessageSendHybridViberRequestSettingsBuilder(viber, this);
    }

    public TsMessageSendHybridRequest build() {
        if (sms != null) {
            message.setSms(sms);
        }
        if (viber != null) {
            message.setViber(viber);
        }
        return message;
    }

    void setSms(TsMessageSendSmsRequestImpl sms) {
        this.sms = sms;
    }

    void setViber(TsMessageSendViberRequestImpl viber) {
        this.viber = viber;
    }

    @Override
    protected TsMessageSendHybridRequestBuilder getBuilder() {
        return this;
    }
}
