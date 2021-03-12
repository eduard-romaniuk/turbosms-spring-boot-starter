package io.github.eduardromanyuk.turbosms.model.response;

import java.time.LocalDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import io.github.eduardromanyuk.turbosms.model.request.LocalDateTimeDeserializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class TsMessageStatus extends TsResponseStatus {
	private String message_id;
	private String recipient;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime sent;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime updated;
	private String status;
	private String type;
	private String rejected_status;
	@JsonDeserialize(using = LocalDateTimeDeserializer.class)
	private LocalDateTime click_time;

	/**
	 * If true only response_status, response_code and message_id fields will be not-null
	 */
	public boolean isStatusEmpty() {
		return status == null;
	}

	/**
	 * If false only response_status, response_code and message_id fields will be not-null
	 */
	public boolean isStatusPresent() {
		return !isStatusEmpty();
	}

	/**
	 * If true rejected_status, click_time fields will be always null
	 */
	public boolean isSmsMessageStatus() {
		return "sms".equals(type);
	}

	/**
	 * If true all fields will ve available
	 */
	public boolean isViberMessageStatus() {
		return "viber".equals(type);
	}
}
