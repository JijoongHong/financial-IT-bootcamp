package comento.financialITBootcamp.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum statusEnum {

    OK("200", "OK"),
    BAD_REQUEST("400", "BAD_REQUEST"),
    NOT_FOUND("404", "NOT_FOUND"),
    INTERNAL_SERVER_ERROR("500", "INTERNAL_SERVER_ERR0R");

    private String codeNumber;
    private String codeMessage;

}
