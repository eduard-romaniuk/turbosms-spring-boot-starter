package org.eduard.romaniuk.turbosms.model.request.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.eduard.romaniuk.turbosms.model.request.TurboSmsMessage;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
public class BasicTurboSmsSmsMessage implements TurboSmsMessage {
    private List<String> recipients;
    private Sms sms;

    public BasicTurboSmsSmsMessage(String sender, String text, List<String> recipients) {
        this.sms = new Sms(sender, text);
        this.recipients = recipients;
    }

    public BasicTurboSmsSmsMessage(String sender, String text, String... recipients) {
        this.sms = new Sms(sender, text);
        this.recipients = Arrays.asList(recipients);
    }

    @Getter
    @Setter
    @ToString
    private class Sms {
        private String sender;
        private String text;

        Sms(String text) {
            this.text = text;
        }

        Sms(String sender, String text) {
            this.sender = sender;
            this.text = text;
        }
    }
}
