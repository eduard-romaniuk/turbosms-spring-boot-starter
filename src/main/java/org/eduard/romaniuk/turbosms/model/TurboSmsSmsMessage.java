package org.eduard.romaniuk.turbosms.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
public class TurboSmsSmsMessage {
    private List<String> recipients;
    private Sms sms;

    public TurboSmsSmsMessage(String sender, String text, List<String> recipients) {
        this.sms = new Sms(sender, text);
        this.recipients = recipients;
    }

    public TurboSmsSmsMessage(String sender, String text, String... recipients) {
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
