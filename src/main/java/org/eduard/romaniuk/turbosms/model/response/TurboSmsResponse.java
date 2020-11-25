package org.eduard.romaniuk.turbosms.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TurboSmsResponse {
    private int response_code;
    private String response_status;
    private List<ResponseResult> response_result;

    @Getter
    @Setter
    @ToString
    private class ResponseResult {
        private String phone;
        private int response_code;
        private String message_id;
        private String response_status;
    }
}
