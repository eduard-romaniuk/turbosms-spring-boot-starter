package io.github.eduardromanyuk.turbosms.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString(callSuper = true)
public final class TsResponseWrapper<T> extends TsResponseStatus {
	@JsonProperty("response_result")
	private final T responseResult;

	public TsResponseWrapper(int responseCode, String responseStatus, T responseResult) {
		super(responseCode, responseStatus);
		this.responseResult = responseResult;
	}
}
