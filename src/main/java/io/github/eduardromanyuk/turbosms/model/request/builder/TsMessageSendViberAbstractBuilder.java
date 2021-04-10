package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.impl.TsMessageSendViberMessageImpl;

public abstract class TsMessageSendViberAbstractBuilder<B extends TsMessageSendAbstractBuilder<TsMessageSendViberMessageImpl, B>>
        extends TsMessageSendAbstractBuilder<TsMessageSendViberMessageImpl, B> {
    
    protected TsMessageSendViberAbstractBuilder(TsMessageSendViberMessageImpl message) {
        super(message);
    }
    
    public B ttl(int ttl) {
        message.setTtl(ttl);
        return getBuilder();
    }

    public B imageUrl(String imageUrl) {
        message.setImageUrl(imageUrl);
        return getBuilder();
    }

    public B caption(String caption) {
        message.setCaption(caption);
        return getBuilder();
    }

    public B action(String action) {
        message.setAction(action);
        return getBuilder();
    }

    public B countClicks() {
        message.setCountClicks(true);
        return getBuilder();
    }

    public B transactional() {
        message.setTransactional(true);
        return getBuilder();
    }

    public B fileId(long id) {
        if (id < 1) {
            throw new IllegalArgumentException("id cannot be less than 1");
        }
        message.setFileId(id);
        return getBuilder();
    }
}
