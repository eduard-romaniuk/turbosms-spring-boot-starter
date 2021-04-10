package io.github.eduardromanyuk.turbosms.model.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import io.github.eduardromanyuk.turbosms.model.request.LocalDateTimeDeserializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class TsFileResponse {
    private long id;
    private String link;
    private String source;
    private long size;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime created;
}
