package projectName.theDogApi.dataModel.Image;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Image_Datamodel {
    private String sub_id;
    private String file;
}
