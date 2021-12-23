package projectName.local.users.dataModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class LocalUsers_DataVault {
    private String email;
    private String first_name;
    private String last_name;
    private String job;
    private int id;
}
