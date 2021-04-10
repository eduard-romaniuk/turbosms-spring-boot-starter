package io.github.eduardromanyuk.turbosms.model.request.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class TsMessageSendRequestImpl {
    private List<String> recipients;
    private String sender;
    private String text;
    private LocalDateTime startTime;
}
