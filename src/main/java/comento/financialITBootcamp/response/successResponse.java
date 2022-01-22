package comento.financialITBootcamp.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class successResponse<T> extends defaultResponse{

    private String status;
    private String result = "success";
    private String description;
    private T data;

    public successResponse(String status, String description, T data){
        this.status = status;
        this.description = description;
        this.data = data;
    }

}
