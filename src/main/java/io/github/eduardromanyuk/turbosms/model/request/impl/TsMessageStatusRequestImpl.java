package io.github.eduardromanyuk.turbosms.model.request.impl;

import java.util.Arrays;
import java.util.List;

import io.github.eduardromanyuk.turbosms.model.request.TsMessageStatusRequest;
import lombok.Getter;

@Getter
public class TsMessageStatusRequestImpl implements TsMessageStatusRequest {
	private final List<String> messages;

	public TsMessageStatusRequestImpl(List<String> messages) {
		this.messages = messages;
	}

	public static TsMessageStatusRequestImpl of(String... messages) {
		return new TsMessageStatusRequestImpl(Arrays.asList(messages));
	}
}
