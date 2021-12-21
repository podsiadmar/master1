package projectName.reqres.register.dataModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Register {
    @JsonProperty("email")
    private String email;
    @JsonProperty("password")
    private String password;

    private int id;
    private String token;
}
