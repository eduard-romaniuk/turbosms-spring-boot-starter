package io.github.eduardromanyuk.turbosms.model.request.impl;

import java.util.Arrays;
import java.util.List;

import io.github.eduardromanyuk.turbosms.model.request.TsStatusRequest;

public class TsStatusRequestImpl implements TsStatusRequest {
	private final List<String> messages;

	public TsStatusRequestImpl(List<String> messages) {
		this.messages = messages;
	}

	public static TsStatusRequestImpl of(String... messages) {
		return new TsStatusRequestImpl(Arrays.asList(messages));
	}

	@Override
	public List<String> messages() {
		return messages;
	}
}
