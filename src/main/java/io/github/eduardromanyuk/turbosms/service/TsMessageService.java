package io.github.eduardromanyuk.turbosms.service;

import io.github.eduardromanyuk.turbosms.model.request.TsHybridMessage;
import io.github.eduardromanyuk.turbosms.model.request.TsSmsMessage;
import io.github.eduardromanyuk.turbosms.model.request.TsMessageStatusRequest;
import io.github.eduardromanyuk.turbosms.model.request.TsViberMessage;
import io.github.eduardromanyuk.turbosms.model.response.TsBalanceResponse;
import io.github.eduardromanyuk.turbosms.model.response.TsMessageStatusResponse;
import io.github.eduardromanyuk.turbosms.model.response.TsResponse;
import io.github.eduardromanyuk.turbosms.model.response.TsResponseWrapper;

import java.util.List;
import java.util.Optional;

public interface TsMessageService {
    Optional<TsResponse> send(TsSmsMessage smsMessage);

    Optional<TsResponse> send(TsViberMessage viberMessage);

    Optional<TsResponse> send(TsHybridMessage hybridMessage);

    Optional<TsResponseWrapper<List<TsMessageStatusResponse>>> status(TsMessageStatusRequest statusRequest);

    Optional<TsResponseWrapper<TsBalanceResponse>> balance();
}
