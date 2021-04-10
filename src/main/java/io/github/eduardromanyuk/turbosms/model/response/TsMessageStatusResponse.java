package io.github.eduardromanyuk.turbosms.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eduardromanyuk.turbosms.json.JsonLocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = false, of = "messageId")
public final class TsMessageStatusResponse extends TsResponseStatus {
	private static final String VIBER = "viber";
	private static final String SMS = "sms";

	@JsonProperty("message_id")
	private final String messageId;

	@JsonProperty("recipient")
	private final String recipient;

	@JsonLocalDateTime
	@JsonProperty("sent")
	private final LocalDateTime sent;

	@JsonLocalDateTime
	@JsonProperty("updated")
	private final LocalDateTime updated;

	@JsonProperty("status")
	private final String status;

	@JsonProperty("type")
	private final String type;

	@JsonProperty("rejected_status")
	private final String rejectedStatus;

	@JsonLocalDateTime
	@JsonProperty("click_time")
	private final LocalDateTime clickTime;

	public TsMessageStatusResponse(int responseCode, String responseStatus, String messageId, String recipient,
								   LocalDateTime sent, LocalDateTime updated, String status, String type,
								   String rejectedStatus, LocalDateTime clickTime) {
		super(responseCode, responseStatus);
		this.messageId = messageId;
		this.recipient = recipient;
		this.sent = sent;
		this.updated = updated;
		this.status = status;
		this.type = type;
		this.rejectedStatus = rejectedStatus;
		this.clickTime = clickTime;
	}

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
