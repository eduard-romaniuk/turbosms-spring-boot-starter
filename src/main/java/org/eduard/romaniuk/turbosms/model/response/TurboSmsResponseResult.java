package org.eduard.romaniuk.turbosms.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TurboSmsResponseResult {
    private String phone;
    private int response_code;
    private String message_id;
    private String response_status;
}
