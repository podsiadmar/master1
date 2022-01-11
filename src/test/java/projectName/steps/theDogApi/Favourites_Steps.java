package projectName.steps.theDogApi;

import common.steps.Base_Steps;
import io.cucumber.java.en.When;
import projectName.theDogApi.Favourites_Endpoint;
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
    @When("User send POST request to Favourites endpoint to save image as favourite")
    public void sendPostToFavourites() {
        sendPostRequest(path, endpoint.getRequestBody(), true);
    }
}
