package projectName.theDogApi;

import common.BaseEndpoint;
import common.IEndpoint;

public class Images_Endpoint extends BaseEndpoint implements IEndpoint {

    private final Class<Images_Endpoint[]> classType = Images_Endpoint[].class;
    public final String imagesPath = "/images/{id}";
    public final String imagesSearch = "/images/search";
    public final String imagesUpload = "/images/upload";
    public final String imagesIdBreeds = "/images/{id}/breeds/{parameter}";

    public Images_Endpoint() {
        super.initRequestBody(classType, "projectName/theDogApi/favourites/favourites.json");
    }

    public void setImagesDataByKeyName(String key, String value) {super.setValueOfField(key, value, super.getDataModelAsArray(classType)[0]);}

    public void convertResponseToDataModel(String response) {super.convertJsonToDataModelArray(response, classType);}

    public Images_Endpoint getImagesDataModel(){ return super.getDataModelAsArray(classType)[0];}


}
