package io.github.eduardromanyuk.turbosms.model.request;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface TsMessageStatusRequest {
	@JsonProperty("messages")
	List<String> getMessages();
}
