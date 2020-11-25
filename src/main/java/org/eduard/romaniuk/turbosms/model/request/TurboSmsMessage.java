package org.eduard.romaniuk.turbosms.model.request;

import java.util.List;

public interface TurboSmsMessage {
    List<String> getRecipients();

    TurboSmsSmsSettings getSms();
}
