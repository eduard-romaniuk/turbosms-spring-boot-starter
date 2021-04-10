package io.github.eduardromanyuk.turbosms.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.eduardromanyuk.turbosms.json.JsonLocalDateTime;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class TsFileAddResponse {
    @JsonProperty("id")
    private long id;

    @JsonProperty("link")
    private String link;

    @JsonProperty("source")
    private String source;

    @JsonProperty("size")
    private long size;

    @JsonLocalDateTime
    @JsonProperty("created")
    private LocalDateTime created;
}
