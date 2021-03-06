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
        users.setFirst_Name(user.get("first_name"));
        users.setLast_Name(user.get("last_name"));
        users.setEmail(user.get("email"));
        users.setAvatar(user.get("avatar"));
        users.setId(Integer.parseInt(user.get("id")));
        return users;
    }


    @DataTableType
    public Users_DataModel setUsersDataObject(Map<String, String> user) {
        Users_DataModel users = new Users_DataModel();
        users.setJob(user.get("job"));
        users.setName(user.get("name"));
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

    @Then("Users TEST")
    public void usersResponseShouldHaveAtLeastOneResultLike1(Users expectedUsersResult) {
        //Act
        Users actualUsersResult = endpoint.getUserResultByName(expectedUsersResult.getFirst_Name());

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



    //endregion
}
