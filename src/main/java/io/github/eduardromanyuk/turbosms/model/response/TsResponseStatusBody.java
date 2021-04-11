package io.github.eduardromanyuk.turbosms.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TsResponseStatusBody {
	@JsonProperty("response_code")
	private int responseCode;

	@JsonProperty("response_status")
	private TsResponseStatus responseStatus;
}
