package projectName.reqres.register.dataModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Register {
    private String email;
    @JsonProperty("password")
    private String password;
}
