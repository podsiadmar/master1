package projectName.theDogApi.dataModel.Breeds;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Breeds_Datamodel {

    private List<Breeds> breeds;

}
