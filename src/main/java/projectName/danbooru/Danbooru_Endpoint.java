package projectName.danbooru;

import common.BaseEndpoint;
import common.IEndpoint;
import projectName.danbooru.dataModel.Danboruu_DataModel;

public class Danbooru_Endpoint extends BaseEndpoint implements IEndpoint {

    private final Class<Danboruu_DataModel[]> classType = Danboruu_DataModel[].class;

    public final String getPath = "/posts/{id}.json";

    public Danbooru_Endpoint() {
        super.initRequestBody(classType, "projectName/danbooru/danbooru.json");
    }


    public void convertResponseToDataModel(String response)  {
        super.convertJsonToDataModelArray(response, classType);
    }


}
