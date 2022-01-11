package projectName.theDogApi.dataModel.Breeds;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.lang.reflect.Array;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Breeds {

    private String id;
    private String name;
    private String bred_for;
    private String breed_group;
    private String life_span;
    private String temperament;
    private String origin;
    private String reference_image_id;

}
