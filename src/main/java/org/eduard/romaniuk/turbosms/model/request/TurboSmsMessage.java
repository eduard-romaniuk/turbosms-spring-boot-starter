package org.eduard.romaniuk.turbosms.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public interface TurboSmsMessage {
    List<String> getRecipients();

    TurboSmsSmsSettings getSms();
}
