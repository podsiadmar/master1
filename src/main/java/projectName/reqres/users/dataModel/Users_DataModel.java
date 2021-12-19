package projectName.reqres.users.dataModel;


import lombok.Data;

import java.util.List;

@SuppressWarnings("unused")
@Data
public class Users_DataModel {
    private String name;
    private String job;
    private String id;
    private String createdAt;

    private Integer count;
    private List<Users> users;
    private Support support;
}
