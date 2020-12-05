package io.github.eduardromanyuk.turbosms.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TsResponseResult {
    private String phone;
    private int response_code;
    private String message_id;
    private String response_status;
}
