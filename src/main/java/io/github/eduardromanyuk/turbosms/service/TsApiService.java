package io.github.eduardromanyuk.turbosms.service;

import io.github.eduardromanyuk.turbosms.model.request.*;
import io.github.eduardromanyuk.turbosms.model.response.*;
import reactor.core.publisher.Mono;

import java.util.List;

public interface TsApiService {
    Mono<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendSmsRequest smsMessage);

    Mono<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendViberMessage viberMessage);

    Mono<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendHybridRequest hybridMessage);

    Mono<TsResponseWrapper<List<TsMessageStatusResponse>>> messageStatus(TsMessageStatusRequest statusRequest);

    Mono<TsResponseWrapper<TsUserBalanceResponse>> userBalance();

    Mono<TsResponseWrapper<TsFileAddResponse>> fileAdd(TsFileAddUrlRequest urlRequest);

    Mono<TsResponseWrapper<TsFileAddResponse>> fileAdd(TsFileAddDataRequest dataRequest);

    Mono<TsResponseWrapper<TsFileAddResponse>> fileDetails(long id);
}
