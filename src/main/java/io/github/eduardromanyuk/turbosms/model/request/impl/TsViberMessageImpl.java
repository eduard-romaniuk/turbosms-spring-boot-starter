package io.github.eduardromanyuk.turbosms.model.request.impl;

import io.github.eduardromanyuk.turbosms.model.request.TsViberMessage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class TsViberMessageImpl extends TsMessageImpl implements TsViberMessage {
    private Integer ttl;
    private String imageUrl;
    private String caption;
    private String action;
    private Boolean countClicks;
    private Boolean transactional;

    public TsViberMessageImpl(String sender) {
        this.sender = sender;
    }

    public TsViberMessageImpl() {}
}
