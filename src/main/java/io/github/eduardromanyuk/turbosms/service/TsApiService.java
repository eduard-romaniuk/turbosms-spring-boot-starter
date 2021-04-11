package io.github.eduardromanyuk.turbosms.service;

import io.github.eduardromanyuk.turbosms.model.request.*;
import io.github.eduardromanyuk.turbosms.model.response.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TsApiService {
    ResponseEntity<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendSmsRequest smsMessage);

    ResponseEntity<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendViberRequest viberMessage);

    ResponseEntity<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendHybridRequest hybridMessage);

    ResponseEntity<TsResponseWrapper<List<TsMessageStatusResponse>>> messageStatus(TsMessageStatusRequest statusRequest);

    ResponseEntity<TsResponseWrapper<TsUserBalanceResponse>> userBalance();

    ResponseEntity<TsResponseWrapper<TsFileAddResponse>> fileAdd(TsFileAddUrlRequest urlRequest);

    ResponseEntity<TsResponseWrapper<TsFileAddResponse>> fileAdd(TsFileAddDataRequest dataRequest);

    ResponseEntity<TsResponseWrapper<TsFileAddResponse>> fileDetails(long id);
}
