package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.impl.TsViberMessageImpl;

public abstract class TsViberMessageAbstractBuilder<B extends TsMessageAbstractBuilder<TsViberMessageImpl, B>>
        extends TsMessageAbstractBuilder<TsViberMessageImpl, B>{
    
    protected TsViberMessageAbstractBuilder(TsViberMessageImpl message) {
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
}
