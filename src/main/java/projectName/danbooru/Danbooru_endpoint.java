package projectName.danbooru;

import common.BaseEndpoint;
import common.IEndpoint;
import projectName.danbooru.dataModel.Danboruu_DataModel;

public class Danbooru_endpoint  extends BaseEndpoint implements IEndpoint {

    private final Class<Danboruu_DataModel[]> classType = Danboruu_DataModel[].class;

    public final String authenticationPath = "/profile.json";


    public void convertResponseToDataModel(String response)  {
        super.convertJsonToDataModelArray(response, classType);
    }
}
