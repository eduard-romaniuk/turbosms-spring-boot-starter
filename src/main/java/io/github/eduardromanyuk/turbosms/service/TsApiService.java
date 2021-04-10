package io.github.eduardromanyuk.turbosms.service;

import io.github.eduardromanyuk.turbosms.model.request.*;
import io.github.eduardromanyuk.turbosms.model.response.*;

import java.util.List;
import java.util.Optional;

public interface TsApiService {
    Optional<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendSmsRequest smsMessage);

    Optional<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendViberMessage viberMessage);

    Optional<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendHybridRequest hybridMessage);

    Optional<TsResponseWrapper<List<TsMessageStatusResponse>>> messageStatus(TsMessageStatusRequest statusRequest);

    Optional<TsResponseWrapper<TsUserBalanceResponse>> userBalance();

    Optional<TsResponseWrapper<TsFileAddResponse>> fileAdd(TsFileAddUrlRequest urlRequest);

    Optional<TsResponseWrapper<TsFileAddResponse>> fileAdd(TsFileAddDataRequest dataRequest);

    Optional<TsResponseWrapper<TsFileAddResponse>> fileDetails(long id);
}
