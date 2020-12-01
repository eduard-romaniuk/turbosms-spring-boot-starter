package org.eduard.romaniuk.turbosms.model.request.builder;

import org.eduard.romaniuk.turbosms.model.request.impl.TsHybridMessageImpl;
import org.eduard.romaniuk.turbosms.model.request.impl.TsSmsMessageImpl;
import org.eduard.romaniuk.turbosms.model.request.impl.TsViberMessageImpl;

public class TsHybridMessageBuilder extends TsMessageAbstractBuilder<TsHybridMessageImpl, TsHybridMessageBuilder> {
    private TsSmsMessageImpl sms;
    private TsViberMessageImpl viber;

    private TsHybridMessageBuilder(String sender) {
        super(new TsHybridMessageImpl(sender));
        this.sms = new TsSmsMessageImpl();
        this.viber = new TsViberMessageImpl();
    }

    private TsHybridMessageBuilder(String smsSender, String viberSender) {
        super(new TsHybridMessageImpl());
        this.sms = new TsSmsMessageImpl(smsSender);
        this.viber = new TsViberMessageImpl(viberSender);
    }

    public static TsHybridMessageBuilder from(String sender) {
        return new TsHybridMessageBuilder(sender);
    }

    public static TsHybridMessageBuilder from(String smsSender, String viberSender) {
        return new TsHybridMessageBuilder(smsSender, viberSender);
    }

    public TsHybridMessageSmsSettingsBuilder smsSettings() {
        return new TsHybridMessageSmsSettingsBuilder(sms, this);
    }

    public TsHybridMessageViberSettingsBuilder viberSettings() {
        return new TsHybridMessageViberSettingsBuilder(viber, this);
    }

    public TsHybridMessageImpl build() {
        if (sms != null) {
            message.setSms(sms);
        }
        if (viber != null) {
            message.setViber(viber);
        }
        return message;
    }

    void setSms(TsSmsMessageImpl sms) {
        this.sms = sms;
    }

    void setViber(TsViberMessageImpl viber) {
        this.viber = viber;
    }

    @Override
    protected TsHybridMessageBuilder getBuilder() {
        return this;
    }
}
