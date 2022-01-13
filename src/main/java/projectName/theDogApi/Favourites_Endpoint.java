package projectName.theDogApi;

import common.BaseEndpoint;
import common.IEndpoint;
import projectName.theDogApi.dataModel.Favourites.Favourites_Datamodel;

public class Favourites_Endpoint extends BaseEndpoint implements IEndpoint {

    private final Class<Favourites_Datamodel[]> classType = Favourites_Datamodel[].class;
    public final String path = "/favourites/{id}";

    public Favourites_Endpoint() {
        super.initRequestBody(classType, "projectName/theDogApi/favourites/favourites.json");
    }

    public void setFavouritesDataByKeyName(String key, String value) {super.setValueOfField(key, value, super.getDataModelAsArray(classType)[0]);}

    public void convertResponseToDataModel(String response) {super.convertJsonToDataModelArray(response, classType);}

    public Favourites_Datamodel getFavouritesDataModel(){ return super.getDataModelAsArray(classType)[0];}

}
