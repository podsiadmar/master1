package projectName.reqres.users.dataModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Users {
    @JsonProperty("ID")
    private int id;
    @JsonProperty("EMAIL")
    private String email;
    @JsonProperty("FIRST_NAME")
    private String firstName;
    @JsonProperty("LAST_NAME")
    private String lastName;
    @JsonProperty("AVATAR")
    private String avatar;


}
