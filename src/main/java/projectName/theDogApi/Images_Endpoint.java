package projectName.theDogApi;

import common.BaseEndpoint;
import projectName.theDogApi.dataModel.Favourites.Favourites_Datamodel;

public class Images_Endpoint extends BaseEndpoint {

    private final Class<Images_Endpoint[]> classType = Images_Endpoint[].class;
    public final String imagesPath = "/images/{id}";
    public final String imagesSearch = "/images/search";
    public final String imagesUpload = "/images/upload";


}
