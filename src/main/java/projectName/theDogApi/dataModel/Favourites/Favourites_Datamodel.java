package projectName.theDogApi.dataModel.Favourites;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Favourites_Datamodel {
    private String id;
    private String user_id;
    private String image_id;
    private String sub_id;
    private String created_at;
    private List<Image> image;

}
