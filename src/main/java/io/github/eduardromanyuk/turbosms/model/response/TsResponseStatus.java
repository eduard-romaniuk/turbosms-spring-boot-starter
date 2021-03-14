package io.github.eduardromanyuk.turbosms.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TsResponseStatus {
	private int response_code;
	private String response_status;
}
