package projectName.steps.local;

import common.steps.Base_Steps;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.sl.In;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import projectName.local.users.LocalUsers_Endpoint;
import projectName.local.users.dataModel.LocalUsers;
import projectName.local.users.dataModel.LocalUsers_Datamodel;
import projectName.reqres.users.dataModel.Users;
import projectName.reqres.users.dataModel.Users_DataModel;
import testUtils.RestAssuredContext;
import utils.TestContext;

import java.util.Map;

public class LocalUsers_Steps extends Base_Steps {

    private final LocalUsers_Endpoint endpoint = new LocalUsers_Endpoint();
    private final String path = endpoint.path;

    public LocalUsers_Steps(TestContext testContext, RestAssuredContext restAssuredContext) {
        super(testContext, restAssuredContext);
        super.setEndpoint(endpoint);
    }

    @DataTableType
    public LocalUsers setData(Map<String, String> users){
        LocalUsers localUsers = new LocalUsers();
        localUsers.setEmail(users.get("email"));
        localUsers.setFirst_name(users.get("first_name"));
        localUsers.setLast_name(users.get("last_name"));
        localUsers.setJob(users.get("job"));
        localUsers.setId(Integer.parseInt(users.get("ID")));
        return localUsers;
    }

    private String changeNullToEmptyString(String value) {
        return value == null ? "" : value;
    }

    //region When=================================
    @When("Send GET request to Local Server")
    public void sendGetRequestToLocalServer() {
        sendGetRequest(path, true);
        System.out.println(restAssuredContext.getResponse().andReturn().body().asString());

    }

    @When("Send POST request to Local Server")
    public void sendPostRequestToLocalServer(){
        sendPostRequest(path, endpoint.getRequestBody(), true);
        System.out.println(restAssuredContext.getResponse().andReturn().body().asString());
    }

    @When("User defines request with query parameter {string} from response body")
    public void defineQueryParamFromResponse(String key) {
        String value = restAssuredContext.getResponse().jsonPath().get(key).toString();
        restAssuredContext.getRequestSpecification().queryParam(key, value);
    }

    @When("User updates user request with {} and {} value")
    public void setData(String key, String value) {
        endpoint.setUserDataByKeyName(key, value);
    }

    @When("Save the response data")
    public void safeDataFromUserResponse(){
        LocalUsers_Datamodel  actualUserData = endpoint.getUserDataModel();
        System.out.println("ok");
    }

    @Then("LocalUsers response should have at least one result like")
    public void localUsersResponseShouldHaveAtLeastOneResultLike(LocalUsers expectedUsersResult) {
        //Act
        LocalUsers_Datamodel actualUsersResult = endpoint.getUserDataModel();

        //Assert
        Assert.assertEquals(actualUsersResult, expectedUsersResult);
        Assertions.assertThat(actualUsersResult).isEqualTo(expectedUsersResult);
    }
}
