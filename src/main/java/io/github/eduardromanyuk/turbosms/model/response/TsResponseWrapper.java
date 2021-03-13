package io.github.eduardromanyuk.turbosms.model.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class TsResponseWrapper<T> extends TsResponseStatus {
	private T response_result;
}
