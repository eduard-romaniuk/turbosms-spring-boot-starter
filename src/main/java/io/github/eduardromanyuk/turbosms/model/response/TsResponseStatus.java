package io.github.eduardromanyuk.turbosms.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class TsResponseStatus {
	@JsonProperty("response_code")
	private final int responseCode;

	@JsonProperty("response_status")
	private final String responseStatus;
}
