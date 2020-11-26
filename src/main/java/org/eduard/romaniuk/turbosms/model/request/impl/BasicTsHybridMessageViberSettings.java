package org.eduard.romaniuk.turbosms.model.request.impl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BasicTsHybridMessageViberSettings {
    private final TsViberMessageImpl message;
    private final BasicTsHybridMessage hybrid;

    BasicTsHybridMessageViberSettings(TsViberMessageImpl message, BasicTsHybridMessage hybrid) {
        this.message = message;
        this.hybrid = hybrid;
    }

    public BasicTsHybridMessageViberSettings text(String text) {
        message.setText(text);
        return this;
    }

    public BasicTsHybridMessageViberSettings recipients(List<String> recipients) {
        message.setRecipients(recipients);
        return this;
    }

    public BasicTsHybridMessageViberSettings recipients(String... recipients) {
        message.setRecipients(Arrays.asList(recipients));
        return this;
    }

    public BasicTsHybridMessageViberSettings recipient(String recipient) {
        if (message.getRecipients() == null) {
            message.setRecipients(new LinkedList<>());
        }
        message.getRecipients().add(recipient);
        return this;
    }

    public BasicTsHybridMessageViberSettings startTime(LocalDateTime startTime) {
        message.setStartTime(startTime);
        return this;
    }

    public BasicTsHybridMessageViberSettings ttl(int ttl) {
        message.setTtl(ttl);
        return this;
    }

    public BasicTsHybridMessageViberSettings imageUrl(String imageUrl) {
        message.setImageUrl(imageUrl);
        return this;
    }

    public BasicTsHybridMessageViberSettings caption(String caption) {
        message.setCaption(caption);
        return this;
    }

    public BasicTsHybridMessageViberSettings action(String action) {
        message.setAction(action);
        return this;
    }

    public BasicTsHybridMessageViberSettings countClicks() {
        message.setCountClicks(true);
        return this;
    }

    public BasicTsHybridMessageViberSettings transactional() {
        message.setTransactional(true);
        return this;
    }

    public BasicTsHybridMessage build() {
        hybrid.setViber(message);
        return hybrid;
    }
}
