package projectName.steps.reqres;

import common.steps.Base_Steps;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.When;
import projectName.reqres.register.Register_Endpoint;
import projectName.reqres.register.dataModel.Register;
import projectName.reqres.users.Users_Endpoint;
import testUtils.RestAssuredContext;
import utils.TestContext;

import java.util.Map;

public class Register_Steps extends Base_Steps {

    private final Register_Endpoint endpoint = new Register_Endpoint();
    private final String path = endpoint.path;

    public Register_Steps(TestContext testContext, RestAssuredContext restAssuredContext){
        super(testContext, restAssuredContext);
        super.setEndpoint(endpoint);
    }

    @DataTableType
    public Register setData(Map<String, String> register){
        Register registerData = new Register();
        registerData.setEmail(registerData.getEmail());
        registerData.setPassword(registerData.getPassword());
        return registerData;
    }

    //region When
    @When("Send POST request to register new User")
    public void sendPOSTRequestToRegister() {
        sendPostRequest(path, endpoint.getRequestBody(), true);
        String test = restAssuredContext.getResponse().asString();
        String id = restAssuredContext.getResponse().jsonPath().get("id");
        String token = restAssuredContext.getResponse().jsonPath().get("token");

    }
}
