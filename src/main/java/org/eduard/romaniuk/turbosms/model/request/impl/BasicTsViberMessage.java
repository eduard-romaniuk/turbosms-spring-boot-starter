package org.eduard.romaniuk.turbosms.model.request.impl;

import org.eduard.romaniuk.turbosms.model.request.TsViberMessage;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BasicTsViberMessage {
    private final TsViberMessageImpl message;

    private BasicTsViberMessage(String sender) {
        this.message = new TsViberMessageImpl(sender);
    }

    public static BasicTsViberMessage from(String sender) {
        return new BasicTsViberMessage(sender);
    }

    public BasicTsViberMessage text(String text) {
        message.setText(text);
        return this;
    }

    public BasicTsViberMessage recipients(List<String> recipients) {
        message.setRecipients(recipients);
        return this;
    }

    public BasicTsViberMessage recipients(String... recipients) {
        message.setRecipients(Arrays.asList(recipients));
        return this;
    }

    public BasicTsViberMessage recipient(String recipient) {
        if (message.getRecipients() == null) {
            message.setRecipients(new LinkedList<>());
        }
        message.getRecipients().add(recipient);
        return this;
    }

    public BasicTsViberMessage startTime(LocalDateTime startTime) {
        message.setStartTime(startTime);
        return this;
    }

    public BasicTsViberMessage ttl(int ttl) {
        message.setTtl(ttl);
        return this;
    }

    public BasicTsViberMessage imageUrl(String imageUrl) {
        message.setImageUrl(imageUrl);
        return this;
    }

    public BasicTsViberMessage caption(String caption) {
        message.setCaption(caption);
        return this;
    }

    public BasicTsViberMessage action(String action) {
        message.setAction(action);
        return this;
    }

    public BasicTsViberMessage countClicks() {
        message.setCountClicks(true);
        return this;
    }

    public BasicTsViberMessage transactional() {
        message.setTransactional(true);
        return this;
    }

    public TsViberMessage build() {
        return message;
    }
}
