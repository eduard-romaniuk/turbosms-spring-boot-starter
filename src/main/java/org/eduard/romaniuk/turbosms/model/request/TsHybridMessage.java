package org.eduard.romaniuk.turbosms.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public interface TsHybridMessage extends TsMessage {
    TsSmsMessage getSms();
}
