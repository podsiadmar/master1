package projectName.theDogApi.dataModel.Breeds;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BreedsList {


    List<Weight> weight;
    List<Height> height;
    private String id;
    private String name;
    private String bred_for;
    private String breed_group;
    private String life_span;
    private String temperament;
    private String origin;
    private String reference_image_id;
    List<Image> image;

}
