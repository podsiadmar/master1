package projectName.reqres.users.dataModel;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@SuppressWarnings("unused")
@Data
public class Users {
    private int id;
    private String email;
    private String first_Name;
    private String last_Name;
    private String avatar;


}
