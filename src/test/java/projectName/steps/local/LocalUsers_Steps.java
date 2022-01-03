package projectName.steps.local;

import common.steps.Base_Steps;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import projectName.local.users.LocalUsers_Endpoint;
import projectName.local.users.dataModel.LocalUsers;
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
    public LocalUsers setData(Map<String, String> users) {
        LocalUsers localUsers = new LocalUsers();
        localUsers.setEmail(users.get("email"));
        localUsers.setFirst_name(users.get("first_name"));
        localUsers.setLast_name(users.get("last_name"));
        localUsers.setJob(users.get("job"));

        if (users.get("id").equals("DYNAMIC")) {
            localUsers.setId(Integer.parseInt(endpoint.getIdFromDataVault()));
        } else {
            localUsers.setId(Integer.parseInt(users.get("id")));
        }
        return localUsers;
    }

    private String changeNullToEmptyString(String value) {
        return value == null ? "" : value;
    }

    //region When=================================
    @When("Send GET request to Local Server")
    public void sendGetRequestToLocalServer() {
        sendGetRequest(path, true);
    }

    @When("Send POST request to Local Server")
    public void sendPostRequestToLocalServer() {
        sendPostRequest(path, endpoint.getRequestBody(), true);
    }

    @When("Send PUT request to LocalUsers with id {}")
    public void sendPUTRequestToLocalUsers(Integer id) {
        sendPutRequest(path + "/" + id, endpoint.getRequestBody());
    }

    @When("Send PUT request to LocalUsers with Id from response")
    public void sendPUTRequestToLocalUsersWithId() {

        sendPutRequest(path + "/" + endpoint.getId(), endpoint.getRequestBody());
    }

    @When("Send DELETE request to Localusers to remove user with {} id")
    public void sendDeleteRequestToLocalUsersWithGivenId(Integer id) {
        sendDeleteRequest(path + "/" + id, true);
    }

    @When("Send DELETE request to Localusers to remove user id from response")
    public void sendDeleteRequestToLocalUsersWithIdFromResponse() {
        sendDeleteRequest(path + "/" + endpoint.getId(), true);
    }

    @When("User defines request with query parameter {string} from response body")
    public void defineQueryParamFromResponse(String key) {
        restAssuredContext.getRequestSpecification().queryParam(key, restAssuredContext.getResponse().jsonPath().get(key).toString());
    }

    @When("Users defines request with query param ID from previous response")
    public void defineIdQueryParamFromResponse() {
        restAssuredContext.getRequestSpecification().queryParam("id", endpoint.getUserDataModel().getId());
    }

    @When("Users updates request with query param ID from previous response")
    public void updateIdQueryParamFromResponse() {
        restAssuredContext.getRequestSpecification().queryParam("id", endpoint.getUserDataModel().getId());
    }

    @When("User updates user request with id from previous response")
    public void setData() {
        endpoint.setUserDataByKeyName("id", endpoint.getId());
    }


    @When("LocalUser updates request with {} and {} value")
    public void setLocalUserData(String key, String value) {
        endpoint.setUserDataByKeyName(key, value);
    }
    //end region=================================

    //region Then=================================
    @Then("Save results to datavault")
    public void saveResultsToDataVault() {
        endpoint.saveResultsFromDataModelToDataVault();
    }

    @Then("Verify that response contains the same data as stored in DataVault")
    public void assertResponseWithDataFromDataVault() {
        //Act
        LocalUsers localUserDataVault = endpoint.setLocalUserWithDataFromDataVault();
        LocalUsers localUserDataModel = endpoint.getResultsFromDataModel();

        //Assert
        Assert.assertEquals(localUserDataVault, localUserDataModel);
    }

    @Then("LocalUsers response should have at least one result like")
    public void localUsersResponseShouldHaveAtLeastOneResultLike(LocalUsers expectedUsersResult) {
        //Act
        LocalUsers actualUsersResult = endpoint.getResultsFromDataModel();

        //Assert
        Assert.assertEquals(actualUsersResult, expectedUsersResult);
    }

    @Then("Response body should contain email with {} value")
    public void checkResponseEmail(String expectedEmail) {
        //Act
        String actualEmail = endpoint.getEmail();

        //Assert
        Assertions.assertThat(actualEmail).isEqualTo(expectedEmail);
    }

    @Then("Response body should contain first name with {} value")
    public void responseBodyShouldContainFirstNameWithValue(String expectedName) {
        //Act
        String actualName = endpoint.getFirstName();

        //Assert
        Assertions.assertThat(actualName).isEqualTo(expectedName);
    }

    @Then("Response body should contain last name with {} value")
    public void responseBodyShouldContainLastNameWithValue(String expectedName) {
        //Act
        String actualName = endpoint.getLastName();

        //Assert
        Assertions.assertThat(actualName).isEqualTo(expectedName);
    }

    @Then("Response body should contain job with {} value")
    public void responseBodyShouldContainJobWithValue(String expectedJob) {
        //Act
        String actualJob = endpoint.getJob();

        //Assert
        Assertions.assertThat(actualJob).isEqualTo(expectedJob);
    }
    //end region=================================

}
