package org.eduard.romaniuk.turbosms.service;

import org.eduard.romaniuk.turbosms.model.request.TurboSmsMessage;
import org.eduard.romaniuk.turbosms.model.response.TurboSmsResponse;

import java.util.Optional;

public interface TurboSmsMessageService {
    Optional<TurboSmsResponse> send(TurboSmsMessage smsMessage);
}
