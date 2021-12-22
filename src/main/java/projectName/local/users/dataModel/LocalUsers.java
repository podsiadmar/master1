package projectName.local.users.dataModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LocalUsers {
    private String email;
    private String first_name;
    private String last_name;
    private String job;
    @JsonProperty("localID")
    private int id;
}
