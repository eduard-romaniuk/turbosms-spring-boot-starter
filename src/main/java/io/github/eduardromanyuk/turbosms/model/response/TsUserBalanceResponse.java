package io.github.eduardromanyuk.turbosms.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TsUserBalanceResponse {
	@JsonProperty("balance")
	private double balance;
}
