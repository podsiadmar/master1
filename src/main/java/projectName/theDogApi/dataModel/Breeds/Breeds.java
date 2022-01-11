package projectName.theDogApi.dataModel.Breeds;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Breeds {

    private List<Weight> weight;
    private List<Height> height;
    private String id;
    private String name;
    private String bred_for;
    private String breed_group;
    private String life_span;
    private String temperament;
    private String origin;
    private String reference_image_id;
    private List<Image> image;

}
