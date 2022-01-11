package projectName.theDogApi.dataModel.Breeds;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Breeds_Datamodel {

private List<BreedsList> breedsLists;






}
