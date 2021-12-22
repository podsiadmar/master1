package projectName.local.users.dataModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class LocalUsers_Datamodel {
    private String email;
    private String first_name;
    private String last_name;
    private String job;
    @JsonProperty("localID")
    private int id;

    private List<LocalUsers> data;
}
