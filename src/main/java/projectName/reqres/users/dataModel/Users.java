package projectName.reqres.users.dataModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Users {
    private int id;
    private String email;
    @JsonProperty("first_name")
    private String first_Name;
    @JsonProperty("last_name")
    private String last_Name;
    private String avatar;


}
