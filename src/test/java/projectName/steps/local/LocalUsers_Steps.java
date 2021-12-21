package projectName.steps.local;

import common.steps.Base_Steps;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.When;
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
    public LocalUsers setData(Map<String, String> users){
        LocalUsers localUsers = new LocalUsers();
        localUsers.setEmail(users.get("email"));
        localUsers.setFirst_name(users.get("first_name"));
        localUsers.setLast_name(users.get("last_name"));
        localUsers.setJob(users.get("job"));
        return localUsers;
    }

    //region When=================================
    @When("Send GET request to Local Server")
    public void sendGetRequestToLocalServer() {
        sendGetRequest(path, true);
    }
}
