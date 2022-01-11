package projectName.steps.theDogApi;

import common.steps.Base_Steps;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import projectName.theDogApi.Breeds_Endpoint;
import projectName.theDogApi.dataModel.Breeds.BreedsList;
import testUtils.EndpointsPathHandler;
import testUtils.RestAssuredContext;
import utils.TestContext;

import java.util.Map;

public class Breeds_Steps extends Base_Steps {

    private final Breeds_Endpoint endpoint = new Breeds_Endpoint();
    private final String path = endpoint.path;
    
    public Breeds_Steps(TestContext testContext, RestAssuredContext restAssuredContext) {
        super(testContext, restAssuredContext);
        super.setEndpoint(endpoint);
    }

    @DataTableType
    public BreedsList setBreedsObject(Map<String, String> breed) {
        BreedsList breeds = new BreedsList();
        breeds.setId(breed.get("id"));
        breeds.setName(breed.get("name"));
        breeds.setBred_for(breed.get("bred_for"));
        breeds.setBreed_group(breed.get("breed_group"));
        breeds.setLife_span(breed.get("life_span"));
        breeds.setTemperament(breed.get("temperament"));
        breeds.setOrigin(breed.get("origin"));
        return breeds;
    }


    //region When

    @When("User send GET request to Breeds endpoint to return breed list")
    public void sendGetRequestToReturnBreedList(){
        sendGetRequest(EndpointsPathHandler.getPathWithNameParameter(path, ""), true);
        System.out.println(restAssuredContext.getResponse().asString());
    }

    @When("User send GET request to Breeds endpoint to return breed with id {}")
    public void sendGetRequestAndReturnBreedById(String id){
        sendGetRequest(EndpointsPathHandler.getPathWithNameParameter(path, id), true);
        System.out.println(restAssuredContext.getResponse().asString());
    }

    //endregion


    @Then("Print data model")
    public void print(){
        endpoint.getBreedsDataModel();
    }





}
