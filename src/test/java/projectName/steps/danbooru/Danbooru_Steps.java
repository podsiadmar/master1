package projectName.steps.danbooru;

import common.steps.Base_Steps;
import io.cucumber.java.en.When;
import projectName.danbooru.Danbooru_Endpoint;
import testUtils.EndpointsPathHandler;
import testUtils.RestAssuredContext;
import utils.TestContext;

public class Danbooru_Steps extends Base_Steps {

    private final Danbooru_Endpoint endpoint = new Danbooru_Endpoint();
    private final String getPath = endpoint.getPath;

    public Danbooru_Steps(TestContext testContext, RestAssuredContext restAssuredContext) {
        super(testContext, restAssuredContext);
        super.setEndpoint(endpoint);
    }

    //region When
    @When("User sends GET request to Danbooru to retrieve post with {} ID")
    public void sendGetRequestToDanbooruEndpointToGetPostWithID(String id){
        sendGetRequest(EndpointsPathHandler.getPathWithNameParameter(getPath, id));
    }


}
