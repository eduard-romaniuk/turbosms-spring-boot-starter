package io.github.eduardromanyuk.turbosms.model.request.impl;

import io.github.eduardromanyuk.turbosms.model.request.TsMessageSendViberMessage;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class TsMessageSendViberMessageImpl extends TsMessageSendRequestImpl implements TsMessageSendViberMessage {
    private Integer ttl;
    private String imageUrl;
    private String caption;
    private String action;
    private Boolean countClicks;
    private Boolean transactional;
    private Long fileId;

    public TsMessageSendViberMessageImpl(String sender) {
        this.setSender(sender);
    }

    public TsMessageSendViberMessageImpl() {}
}
