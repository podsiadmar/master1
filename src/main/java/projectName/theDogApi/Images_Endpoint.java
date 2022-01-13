package projectName.theDogApi;

import common.BaseEndpoint;
import common.IEndpoint;
import projectName.theDogApi.dataModel.Image.Image_Datamodel;


public class Images_Endpoint extends BaseEndpoint implements IEndpoint {

    private final Class<Image_Datamodel[]> classType = Image_Datamodel[].class;
    public final String imagesPath = "/images/{id}";
    public final String imagesSearch = "/images/search";
    public final String imagesUpload = "/images/upload";
    public final String imagesIdBreeds = "/images/{id}/breeds/{parameter}";

    public Images_Endpoint() {
        super.initRequestBody(classType, "projectName/theDogApi/images/images.json");
    }

    public void setImagesDataByKeyName(String key, String value) {super.setValueOfField(key, value, super.getDataModelAsArray(classType)[0]);}

    public void convertResponseToDataModel(String response) {super.convertJsonToDataModelArray(response, classType);}

    public Image_Datamodel getImagesDataModel(){ return super.getDataModelAsArray(classType)[0];}


}
