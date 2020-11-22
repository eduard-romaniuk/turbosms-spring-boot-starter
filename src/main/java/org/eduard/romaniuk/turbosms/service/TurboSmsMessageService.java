package org.eduard.romaniuk.turbosms.service;

import org.eduard.romaniuk.turbosms.model.TurboSmsResponse;
import org.eduard.romaniuk.turbosms.model.TurboSmsSmsMessage;

import java.util.Optional;

public interface TurboSmsMessageService {
    Optional<TurboSmsResponse> send(TurboSmsSmsMessage smsMessage);
}
