package projectName.reqres.users.dataModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Users {
    private int id;
    private String email;
    private String firstName;
    private String lastName;
    private String avatar;


}
