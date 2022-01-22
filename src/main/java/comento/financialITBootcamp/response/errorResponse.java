package comento.financialITBootcamp.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class errorResponse extends defaultResponse{

    private String status;
    private String result = "fail";
    private String description;

    public errorResponse(String status, String description){
        this.status = status;
        this.description = description;
    }

}