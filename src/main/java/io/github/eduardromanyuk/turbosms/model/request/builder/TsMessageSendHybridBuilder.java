package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.impl.TsMessageSendViberMessageImpl;
import io.github.eduardromanyuk.turbosms.model.request.impl.TsMessageSendHybridRequestImpl;
import io.github.eduardromanyuk.turbosms.model.request.impl.TsMessageSendSmsRequestImpl;

public class TsMessageSendHybridBuilder extends TsMessageSendAbstractBuilder<TsMessageSendHybridRequestImpl, TsMessageSendHybridBuilder> {
    private TsMessageSendSmsRequestImpl sms;
    private TsMessageSendViberMessageImpl viber;

    private TsMessageSendHybridBuilder(String sender) {
        super(new TsMessageSendHybridRequestImpl(sender));
        this.sms = new TsMessageSendSmsRequestImpl();
        this.viber = new TsMessageSendViberMessageImpl();
    }

    private TsMessageSendHybridBuilder(String smsSender, String viberSender) {
        super(new TsMessageSendHybridRequestImpl());
        this.sms = new TsMessageSendSmsRequestImpl(smsSender);
        this.viber = new TsMessageSendViberMessageImpl(viberSender);
    }

    public static TsMessageSendHybridBuilder from(String sender) {
        return new TsMessageSendHybridBuilder(sender);
    }

    public static TsMessageSendHybridBuilder from(String smsSender, String viberSender) {
        return new TsMessageSendHybridBuilder(smsSender, viberSender);
    }

    public TsMessageSendHybridSmsSettingsBuilder smsSettings() {
        return new TsMessageSendHybridSmsSettingsBuilder(sms, this);
    }

    public TsMessageSendHybridViberSettingsBuilder viberSettings() {
        return new TsMessageSendHybridViberSettingsBuilder(viber, this);
    }

    public TsMessageSendHybridRequestImpl build() {
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

    void setViber(TsMessageSendViberMessageImpl viber) {
        this.viber = viber;
    }

    @Override
    protected TsMessageSendHybridBuilder getBuilder() {
        return this;
    }
}
