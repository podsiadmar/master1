package projectName.theDogApi.dataModel.Breeds;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Breeds_Datamodel {

    private Array weight;
        @JsonProperty("weight_imperial")
        private String imperial;
        @JsonProperty("weight_metric")
        private String metric;
    private Array height;
        @JsonProperty("height_imperial")
        private String imperialH;
        @JsonProperty("height_metric")
        private String metricH;
    private String id;
    private String name;
    private String bred_for;
    private String breed_group;
    private String life_span;
    private String temperament;
    private String origin;
    private String reference_image_id;
    private Array image;
        @JsonProperty("id_image")
        private String idI;
        private String width;
        @JsonProperty("height_image")
        private String heightI;
        private String url;

    private List<Breeds> breeds;






}
