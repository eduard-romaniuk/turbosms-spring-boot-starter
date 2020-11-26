package org.eduard.romaniuk.turbosms.service;

import org.eduard.romaniuk.turbosms.model.request.TsSmsMessage;
import org.eduard.romaniuk.turbosms.model.response.TsResponse;

import java.util.Optional;

public interface TsMessageService {
    Optional<TsResponse> send(TsSmsMessage smsMessage);
}
