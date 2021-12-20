package projectName.reqres.users.dataModel;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@SuppressWarnings("unused")
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users_DataModel {
    private String page;
    private String per_page;
    private String total;
    private String total_pages;

    private String name;
    private String job;
    private String id;
    private String createdAt;


    private List<Users> data;
    private Support support;
}
