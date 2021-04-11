package io.github.eduardromanyuk.turbosms.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public interface TsMessageStatusRequest {
	@JsonProperty("messages")
	List<String> getMessages();
}
