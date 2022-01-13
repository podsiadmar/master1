package projectName.steps.theDogApi;

import common.steps.Base_Steps;
import io.cucumber.java.en.When;
import projectName.theDogApi.Favourites_Endpoint;
import projectName.theDogApi.Images_Endpoint;
import testUtils.EndpointsPathHandler;
import testUtils.RestAssuredContext;
import utils.TestContext;

public class Image_Steps extends Base_Steps {

    private final Images_Endpoint endpoint = new Images_Endpoint();
    private final String imagesPath = endpoint.imagesPath;
    private final String imagesSearch = endpoint.imagesSearch;
    private final String imagesUpload = endpoint.imagesUpload;
    private final String imagesIdBreed = endpoint.imagesIdBreeds;



    public Image_Steps(TestContext testContext, RestAssuredContext restAssuredContext) {
        super(testContext, restAssuredContext);
        super.setEndpoint(endpoint);
    }

    //region When

    @When("User sends GET request to Images endpoint and return all images list")
    public void sedGetRequestToSearchImages(){
        sendGetRequest(imagesSearch, true);
    }

    @When("User sends GET request to Images endpoint to return all images uploaded before")
    public void sendGetRequestToRetrieveAllImagesUploadedBefore(){
        sendGetRequest(EndpointsPathHandler.getPathWithNameParameter(imagesPath, ""), true);
    }

    @When("User sends GET request to Images endpoint to return Image with id {}")
    public void sendGetRequestToRetrieveImageWithId(String id){
        sendGetRequest(EndpointsPathHandler.getPathWithNameParameter(imagesPath, id), true);
    }

    @When("User sends POST request to Images endpoint to upload new image")
    public void sendPostRequestToUploadNewImage(){
        sendPostRequest(imagesUpload, endpoint.getRequestBody(), true);
    }

    @When("User sends DELETE request to Images endpoint to remove image with id {}")
    public void sendDeleteRequestToRemoveImage(String id){
        sendDeleteRequest(EndpointsPathHandler.getPathWithNameParameter(imagesPath, id), true);
    }

    @When("User sends GET request to Images endpoint to retrieve breed from image id {}")
    public void sendGetRequestToImagesWithIdToBreed(String id){
        sendGetRequest(EndpointsPathHandler.getPathWithNameParameter(imagesIdBreed, id, ""), true);
    }

    @When("User sends POST request to Images endpoint to add breed to image id {}")
    public void sendPostRequestToImageToAddBreedToImage(String id){
        sendPostRequest(EndpointsPathHandler.getPathWithNameParameter(imagesIdBreed, id, ""), endpoint.getRequestBody(), true);
    }

    @When("Users sends DELETE request to Images endpoint - removing from image id {} and breed id {}")
    public void sendPostRequestToImageToRemoveBreedFromImage(String id, String breed){
        sendPostRequest(EndpointsPathHandler.getPathWithNameParameter(imagesIdBreed, id, breed), endpoint.getRequestBody(), true);
    }



}
