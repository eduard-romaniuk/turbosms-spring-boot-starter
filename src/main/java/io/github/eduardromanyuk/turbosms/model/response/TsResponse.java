package io.github.eduardromanyuk.turbosms.model.response;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
public class TsResponse extends TsResponseWrapper<List<TsResponseResult>> {
}
