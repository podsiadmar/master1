package projectName.local.users.dataModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class LocalUsers_Datamodel {
    private String email;
    private String first_name;
    private String last_name;
    private String job;


}
