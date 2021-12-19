package projectName.reqres.users.dataModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Users {
    @JsonProperty("id")
    private int id;
    @JsonProperty("email")
    private String email;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("avatar")
    private String avatar;


}
