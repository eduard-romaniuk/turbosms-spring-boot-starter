package io.github.eduardromanyuk.turbosms.model.request;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class LocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {
	protected LocalDateTimeDeserializer() {
		super(LocalDateTime.class);
	}

	@Override
	public LocalDateTime deserialize(JsonParser jp, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
		return LocalDateTime.parse(
				jp.getCodec().readValue(jp, String.class),
				DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss")
		);
	}
}
