package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.TsMessageStatusRequest;

import java.util.Arrays;
import java.util.List;

public class TsMessageStatusRequestBuilder {
    private final TsMessageStatusRequestImpl statusRequest;

    public static TsMessageStatusRequest from(String... messageIds) {
        return new TsMessageStatusRequestImpl(Arrays.asList(messageIds));
    }

    public static TsMessageStatusRequest from(List<String> messageIds) {
        return new TsMessageStatusRequestImpl(messageIds);
    }

    public TsMessageStatusRequestBuilder() {
        this.statusRequest = new TsMessageStatusRequestImpl();
    }

    public TsMessageStatusRequestBuilder messages(String... messageIds) {
        this.statusRequest.setMessages(Arrays.asList(messageIds));
        return this;
    }

    public TsMessageStatusRequestBuilder addMessage(String message) {
        this.statusRequest.getMessages().add(message);
        return this;
    }

    public TsMessageStatusRequest build() {
        return this.statusRequest;
    }
}
