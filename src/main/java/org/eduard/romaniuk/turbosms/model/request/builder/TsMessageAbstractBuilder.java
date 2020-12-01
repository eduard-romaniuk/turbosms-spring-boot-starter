package org.eduard.romaniuk.turbosms.model.request.builder;

import org.eduard.romaniuk.turbosms.model.request.impl.TsMessageImpl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class TsMessageAbstractBuilder<T extends TsMessageImpl, B extends TsMessageAbstractBuilder<T, B>> {
    protected T message;

    protected TsMessageAbstractBuilder(T message) {
        this.message = message;
    }

    protected abstract B getBuilder();

    public B text(String text) {
        message.setText(text);
        return getBuilder();
    }

    public B recipients(List<String> recipients) {
        message.setRecipients(recipients);
        return getBuilder();
    }

    public B recipients(String... recipients) {
        message.setRecipients(Arrays.asList(recipients));
        return getBuilder();
    }

    public B recipient(String recipient) {
        if (message.getRecipients() == null) {
            message.setRecipients(new LinkedList<>());
        }
        message.getRecipients().add(recipient);
        return getBuilder();
    }

    public B startTime(LocalDateTime startTime) {
        message.setStartTime(startTime);
        return getBuilder();
    }
}
