package projectName.reqres.register.dataModel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Register_Datamodel {
    private int id;
    private String token;

}
