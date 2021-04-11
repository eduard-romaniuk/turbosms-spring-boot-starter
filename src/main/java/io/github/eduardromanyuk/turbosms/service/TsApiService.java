package io.github.eduardromanyuk.turbosms.service;

import io.github.eduardromanyuk.turbosms.model.request.*;
import io.github.eduardromanyuk.turbosms.model.response.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Provides TurboSMS HTTP API methods as Spring service.
 * @see <a href="https://turbosms.ua">TurboSMS</a>
 * @see <a href="https://turbosms.ua/api.html">TurboSMS HTTP API</a>
 */
public interface TsApiService {
    /**
     * Sends SMS message.
     * TurboSMS method: {@code /message/send.json}.
     * @param smsMessage settings
     * @return sending status
     * @see io.github.eduardromanyuk.turbosms.model.request.builder.TsMessageSendSmsRequestBuilder
     */
    ResponseEntity<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendSmsRequest smsMessage);

    /**
     * Sends Viber message.
     * TurboSMS method: {@code /message/send.json}.
     * @param viberMessage settings
     * @return sending status
     * @see io.github.eduardromanyuk.turbosms.model.request.builder.TsMessageSendViberRequestBuilder
     */
    ResponseEntity<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendViberRequest viberMessage);

    /**
     * Sends a hybrid message. Tries to send a message to Viber and in case of failure send this message as SMS.
     * TurboSMS method: {@code /message/send.json}.
     * @param hybridMessage settings
     * @return sending status
     * @see io.github.eduardromanyuk.turbosms.model.request.builder.TsMessageSendHybridRequestBuilder
     */
    ResponseEntity<TsResponseWrapper<List<TsMessageSendResponse>>> messageSend(TsMessageSendHybridRequest hybridMessage);

    /**
     * Returns messages sending status.
     * TurboSMS method: {@code /message/status.json}.
     * @param statusRequest messageIds
     * @return sending status for selected messages
     * @see io.github.eduardromanyuk.turbosms.model.request.builder.TsMessageStatusRequestBuilder
     */
    ResponseEntity<TsResponseWrapper<List<TsMessageStatusResponse>>> messageStatus(TsMessageStatusRequest statusRequest);

    /**
     * Returns account balance.
     * TurboSMS method: {@code /user/balance.json}.
     * @return account balance
     */
    ResponseEntity<TsResponseWrapper<TsUserBalanceResponse>> userBalance();

    /**
     * Upload file for sending in Viber message.
     * Supported file extensions: doc, docx, rtf, dot, dotx, odt, odf, fodt, txt, pdf, xps, pdax, eps,
     * xls, xlsx, ods, fods, csv, xlsm, xltx, jpg, jpeg, png, gif.
     * The maximum file size is 3 MB.
     * TurboSMS method: {@code /file/add.json}.
     * @param urlRequest file url
     * @return uploaded file details
     * @see io.github.eduardromanyuk.turbosms.model.request.builder.TsFileAddRequestBuilder
     */
    ResponseEntity<TsResponseWrapper<TsFileAddResponse>> fileAdd(TsFileAddUrlRequest urlRequest);

    /**
     * Upload file for sending in Viber message.
     * Supported file extensions: doc, docx, rtf, dot, dotx, odt, odf, fodt, txt, pdf, xps, pdax, eps,
     * xls, xlsx, ods, fods, csv, xlsm, xltx, jpg, jpeg, png, gif.
     * The maximum file size is 3 MB.
     * TurboSMS method: {@code /file/add.json}.
     * @param dataRequest file as data schema
     * @return uploaded file details
     * @see <a href="http://www.faqs.org/rfcs/rfc2397.html">data standard</a>
     * @see io.github.eduardromanyuk.turbosms.model.request.builder.TsFileAddRequestBuilder
     */
    ResponseEntity<TsResponseWrapper<TsFileAddResponse>> fileAdd(TsFileAddDataRequest dataRequest);

    /**
     * Retrieve file details by id.
     * TurboSMS method: {@code /file/details.json}.
     * @param detailsRequest file id
     * @return file details
     * @see io.github.eduardromanyuk.turbosms.model.request.builder.TsFileDetailsRequestBuilder
     */
    ResponseEntity<TsResponseWrapper<TsFileAddResponse>> fileDetails(TsFileDetailsRequest detailsRequest);
}
