package projectName.steps.reqres;

import common.steps.Base_Steps;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import projectName.reqres.users.Users_Endpoint;
import projectName.reqres.users.dataModel.Users;
import projectName.reqres.users.dataModel.Users_DataModel;
import testUtils.RestAssuredContext;
import utils.TestContext;
import java.util.Map;

public class Users_Steps extends Base_Steps {

    private final Users_Endpoint endpoint = new Users_Endpoint();
    private final String path = endpoint.path;

    public Users_Steps(TestContext testContext, RestAssuredContext restAssuredContext) {
        super(testContext, restAssuredContext);
        super.setEndpoint(endpoint);
    }

    @DataTableType
    public Users setUsersObject(Map<String, String> user) {
        Users users = new Users();
        users.setFirstName(changeNullToEmptyString(user.get("first_name")));
        users.setLastName(changeNullToEmptyString(user.get("last_name")));
        users.setEmail(changeNullToEmptyString(user.get("email")));
        users.setAvatar(changeNullToEmptyString(user.get("avatar")));
        users.setId(Integer.parseInt(user.get("id")));
        return users;
    }

    @DataTableType
    public Users_DataModel setUsersDataObject(Map<String, String> user) {
        Users_DataModel users = new Users_DataModel();
        users.setJob(changeNullToEmptyString(user.get("job")));
//        users.setId(changeNullToEmptyString(user.get("id")));
//        users.setCreatedAt(changeNullToEmptyString(user.get("createdAt")));
        users.setName(changeNullToEmptyString(user.get("name")));
        return users;
    }

    private String changeNullToEmptyString(String value) {
        return value == null ? "" : value;
    }



    //region When

    @When("Send GET request to users")
    public void sendGetRequestToEntries() {
        sendGetRequest(path, true);
        String test = restAssuredContext.getResponse().asString();
    }

    @When("Send POST request to users")
    public void sendPOSTRequestToUsers() {
        sendPostRequest(path, endpoint.getRequestBody(), true);
        String test = restAssuredContext.getResponse().asString();
    }

    @When("Send PUT request to users")
    public void sendPUTRequestToUsers() {
        sendPutRequest(path, endpoint.getRequestBody());
    }

    @When("Send DELETE request to users")
    public void sendDELETERequestToUsers() {
        sendDeleteRequest(path);
    }

    @When("User updates request with {} and {} value")
    public void setUserData(String key, String value) {
        endpoint.setUserDataByKeyName(key, value);
    }

    @Then("TEST {} key")
    public void getTest(String key) {
        String test = endpoint.getUserDataTEST(key);

        Assertions.assertThat(test).isEqualTo("");
    }

    //endregion

    //region Then

    @Then("Users response should have at least one result like")
    public void usersResponseShouldHaveAtLeastOneResultLike(Users expectedUsersResult) {
        //Act
        Users actualUsersResult = endpoint.getUserResultByID(expectedUsersResult.getId());

        //Assert
        Assert.assertEquals(actualUsersResult, expectedUsersResult);
        Assertions.assertThat(actualUsersResult).isEqualTo(expectedUsersResult);
    }

    @Then("Response body should contain user data")
    public void checkUserData(Users expectedUserData) {
        //Act
        Users actualUserData = endpoint.getUserData();

        //Assert
        Assertions.assertThat(actualUserData).isEqualTo(expectedUserData);
    }

    @Then("Response body should contain post request data")
    public void responseBodyShouldContainPostRequestData(Users_DataModel expectedUserData) {
        //Act
        Users_DataModel actualUserData = endpoint.getUserDataModel();

        //Assert
        Assertions.assertThat(actualUserData).isEqualTo(expectedUserData);
    }

    @Then("Response body should contain email with {} value")
    public void checkResponseEmail(String expectedEmail) {
        //Act
        String actualEmail = endpoint.getEmail();

        //Assert
        Assertions.assertThat(actualEmail).isEqualTo(expectedEmail);
    }

    @Then("Response body should contain name with {} value")
    public void responseBodyShouldContainNameWithValue(String expectedName) {
        //Act
        String actualName = endpoint.getName();

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

    //endregion
}
