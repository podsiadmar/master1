package projectName.steps.reqres;

import common.steps.Base_Steps;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import projectName.entries.Entries_Endpoint;
import projectName.entries.dataModel.Entries;
import projectName.reqres.users.Users_Endpoint;
import projectName.reqres.users.dataModel.Users;
import testUtils.RestAssuredContext;
import utils.TestContext;

import java.util.Map;

@SuppressWarnings("FieldCanBeLocal")
public class Users_steps extends Base_Steps {

    private final Users_Endpoint endpoint = new Users_Endpoint();
    private final String path = endpoint.path;


    public Users_steps(TestContext testContext, RestAssuredContext restAssuredContext) {
        super(testContext, restAssuredContext);
    }

    @DataTableType
    public Users setUsersObject(Map<String, String> user) {
        Users users = new Users();
        users.setFirstName(changeNullToEmptyString(user.get("FIRST_NAME")));
        users.setLastName(changeNullToEmptyString(user.get("LAST_NAME")));
        users.setEmail(changeNullToEmptyString(user.get("EMAIL")));
        users.setAvatar(changeNullToEmptyString(user.get("AVATAR")));
        users.setId(Integer.parseInt(user.get("ID")));
        return users;
    }

    private String changeNullToEmptyString(String value) {
        return value == null ? "" : value;
    }

    //region when
    @When("Send Get request to users")
    public void sendGetRequestToUsers(){
        sendGetRequest(path, true);
    }

    @When("Send Post request to users")
    public void sendPostRequestToUsers(){
        sendPostRequest(path, endpoint.getRequestBody(), true);
    }

    @Then("User response should have at least one result like")
    public void usersResponseShouldHaveAtLeastOneResultLike(Users expectedUsersResult) {
        //Act
        Users actualUsersResult = endpoint.getUserResultByID(expectedUsersResult.getId());

        //Assert
        Assert.assertEquals(actualUsersResult, expectedUsersResult);
        Assertions.assertThat(actualUsersResult).isEqualTo(expectedUsersResult);
    }

}
