package projectName.theDogApi;
import common.BaseEndpoint;
import common.IEndpoint;
import projectName.theDogApi.dataModel.Breeds.Breeds_Datamodel;

public class Breeds_Endpoint extends BaseEndpoint implements IEndpoint {

    private final Class<Breeds_Datamodel[]> classType = Breeds_Datamodel[].class;

    public final String path = "/breeds/{id}";

    public void convertResponseToDataModel(String response)  {super.convertJsonToDataModelArray(response, classType);}

    public Breeds_Datamodel getBreedsDataModel(){ return super.getDataModelAsArray(classType)[0];}

    public Breeds_Datamodel getBreedsObjectById(String id) {
        for(Breeds_Datamodel breeds : super.getDataModelAsArray(classType)){
            if(breeds.getId().equals(id)){
                return breeds;
            }
        }
        return null;
    }


}
