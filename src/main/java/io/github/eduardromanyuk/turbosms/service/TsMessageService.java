package io.github.eduardromanyuk.turbosms.service;

import io.github.eduardromanyuk.turbosms.model.request.*;
import io.github.eduardromanyuk.turbosms.model.response.*;

import java.util.List;
import java.util.Optional;

public interface TsMessageService {
    Optional<TsResponse> send(TsSmsMessage smsMessage);

    Optional<TsResponse> send(TsViberMessage viberMessage);

    Optional<TsResponse> send(TsHybridMessage hybridMessage);

    Optional<TsResponseWrapper<List<TsMessageStatusResponse>>> status(TsMessageStatusRequest statusRequest);

    Optional<TsResponseWrapper<TsBalanceResponse>> balance();

    Optional<TsResponseWrapper<TsFileResponse>> fileAdd(TsFileUrlRequest urlRequest);

    Optional<TsResponseWrapper<TsFileResponse>> fileAdd(TsFileDataRequest dataRequest);
}
