package io.github.eduardromanyuk.turbosms.model.request.builder;

import io.github.eduardromanyuk.turbosms.model.request.TsMessageStatusRequest;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
class TsMessageStatusRequestImpl implements TsMessageStatusRequest {
	private List<String> messages;

	TsMessageStatusRequestImpl() {
		this.messages = new ArrayList<>();

	}

	TsMessageStatusRequestImpl(List<String> messages) {
		this.messages = new ArrayList<>(messages);
	}

	public void setMessages(List<String> messages) {
		this.messages = new ArrayList<>(messages);
	}
}
