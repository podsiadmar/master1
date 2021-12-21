package projectName.reqres.register.dataModel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Register_Datamodel {
    private String email;
    private String password;



}
