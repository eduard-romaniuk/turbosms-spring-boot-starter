package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.impl.TsMessageSendRequestImpl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public abstract class TsMessageSendAbstractBuilder<T extends TsMessageSendRequestImpl, B extends TsMessageSendAbstractBuilder<T, B>> {
    protected T message;

    protected TsMessageSendAbstractBuilder(T message) {
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
