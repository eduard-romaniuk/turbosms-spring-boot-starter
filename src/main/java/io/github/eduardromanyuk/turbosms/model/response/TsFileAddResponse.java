package io.github.eduardromanyuk.turbosms.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eduardromanyuk.turbosms.json.JsonLocalDateTime;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(of = "id")
public final class TsFileAddResponse {
    @JsonProperty("id")
    private final long id;

    @JsonProperty("link")
    private final String link;

    @JsonProperty("source")
    private final String source;

    @JsonProperty("size")
    private final long size;

    @JsonLocalDateTime
    @JsonProperty("created")
    private final LocalDateTime created;
}
