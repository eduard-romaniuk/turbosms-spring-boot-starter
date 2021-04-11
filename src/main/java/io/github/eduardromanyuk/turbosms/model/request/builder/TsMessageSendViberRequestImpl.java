package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.TsMessageSendViberRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
@Setter(AccessLevel.PACKAGE)
public class TsMessageSendViberRequestImpl extends TsMessageSendRequestImpl implements TsMessageSendViberRequest {
    private Integer ttl;
    private String imageUrl;
    private String caption;
    private String action;
    private Boolean countClicks;
    private Boolean transactional;
    private Long fileId;

    TsMessageSendViberRequestImpl(String sender) {
        this.setSender(sender);
    }

    TsMessageSendViberRequestImpl() {}
}
