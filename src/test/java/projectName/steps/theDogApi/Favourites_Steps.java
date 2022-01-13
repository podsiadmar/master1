package projectName.steps.theDogApi;

import common.steps.Base_Steps;
import io.cucumber.java.en.When;
import projectName.theDogApi.Favourites_Endpoint;
import testUtils.EndpointsPathHandler;
import testUtils.RestAssuredContext;
import utils.TestContext;

public class Favourites_Steps extends Base_Steps {

    private final Favourites_Endpoint endpoint = new Favourites_Endpoint();
    private final String path = endpoint.path;

    public Favourites_Steps(TestContext testContext, RestAssuredContext restAssuredContext) {
        super(testContext, restAssuredContext);
        super.setEndpoint(endpoint);
    }

    //region When
    @When("User sends GET request to Favourites endpoint to retrieve favourites list")
    public void sendGetRequestToRetrieveFavouritesList(){
        sendGetRequest(EndpointsPathHandler.getPathWithNameParameter(path, ""), true);
    }

    @When("User sends GET request to Favourites endpoint to retrieve element with id {}")
    public void sendGetRequestToRetrieveOneFavouriteById(String id){
        sendGetRequest(EndpointsPathHandler.getPathWithNameParameter(path, id), true);
    }


    @When("User sends POST request to Favourites endpoint to save image as favourite")
    public void sendPostToFavourites() {
        sendPostRequest(EndpointsPathHandler.getPathWithNameParameter(path, ""), endpoint.getRequestBody(), true);
    }

    @When("User sends DELETE request to remove favourite with id {}")
    public void sendDeleteRequestToRemoveOneFavourite(String id){
        sendDeleteRequest(EndpointsPathHandler.getPathWithNameParameter(path, id), true);
    }

    @When("User defines body parameter {} with value {}")
    public void defineBodyParameterToFavourites(String key, String value){endpoint.setFavouritesDataByKeyName(key, value);}


}


