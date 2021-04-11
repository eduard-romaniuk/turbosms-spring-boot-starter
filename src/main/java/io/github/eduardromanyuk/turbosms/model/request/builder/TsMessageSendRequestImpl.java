package io.github.eduardromanyuk.turbosms.model.request.builder;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@ToString
@Setter(AccessLevel.PACKAGE)
class TsMessageSendRequestImpl {
    private List<String> recipients;
    private String sender;
    private String text;
    private LocalDateTime startTime;
}
