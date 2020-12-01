package org.eduard.romaniuk.turbosms.model.request.impl;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class TsMessageImpl {
    protected List<String> recipients;
    protected String sender;
    protected String text;
    protected LocalDateTime startTime;
}
