package io.github.eduardromanyuk.turbosms.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eduardromanyuk.turbosms.json.JsonLocalDateTime;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, of = "messageId")
public class TsMessageStatusResponse extends TsResponseStatus {
	private static String VIBER = "viber";
	private static String SMS = "sms";

	@JsonProperty("message_id")
	private String messageId;

	@JsonProperty("recipient")
	private String recipient;

	@JsonLocalDateTime
	@JsonProperty("sent")
	private LocalDateTime sent;

	@JsonLocalDateTime
	@JsonProperty("updated")
	private LocalDateTime updated;

	@JsonProperty("status")
	private String status;

	@JsonProperty("type")
	private String type;

	@JsonProperty("rejected_status")
	private String rejectedStatus;

	@JsonLocalDateTime
	@JsonProperty("click_time")
	private LocalDateTime clickTime;

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
		return SMS.equals(type);
	}

	/**
	 * If true all fields will ve available
	 */
	public boolean isViberMessageStatus() {
		return VIBER.equals(type);
	}
}
