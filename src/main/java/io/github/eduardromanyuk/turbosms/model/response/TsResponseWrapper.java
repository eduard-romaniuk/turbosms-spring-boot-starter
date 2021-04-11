package io.github.eduardromanyuk.turbosms.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class TsResponseWrapper<T> extends TsResponseStatusBody {
	@JsonProperty("response_result")
	private T responseResult;
}
