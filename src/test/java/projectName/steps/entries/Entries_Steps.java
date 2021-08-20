package projectName.steps.entries;

import common.steps.Base_Steps;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import projectName.entries.Entries_Endpoint;
import projectName.entries.dataModel.Entries;
import testUtils.ParseFactory;
import testUtils.RestAssuredContext;
import utils.TestContext;

import java.util.Map;

@SuppressWarnings("FieldCanBeLocal")
public class Entries_Steps extends Base_Steps {

    private final Entries_Endpoint endpoint = new Entries_Endpoint();
    private final String path = endpoint.path;

    public Entries_Steps(TestContext testContext, RestAssuredContext restAssuredContext) {
        super(testContext, restAssuredContext);
        super.setEndpoint(endpoint);
    }

    @When("Send GET request to entries")
    public void sendGetRequestToEntries() {
        sendGetRequest(path, true);
    }

    @DataTableType
    public Entries setEntriesObject(Map<String, String> entry) {
        Entries entries = new Entries();
        entries.setApi(changeNullToEmptyString(entry.get("api")));
        entries.setDescription(changeNullToEmptyString(entry.get("description")));
        entries.setAuth(changeNullToEmptyString(entry.get("auth")));
        entries.setHttps(ParseFactory.customTryParse(changeNullToEmptyString(entry.get("https"))));
        entries.setCors(changeNullToEmptyString(entry.get("cors")));
        entries.setLink(changeNullToEmptyString(entry.get("link")));
        entries.setCategory(changeNullToEmptyString(entry.get("category")));
        return entries;
    }

    private String changeNullToEmptyString(String value) {
        return value == null ? "" : value;
    }

    @Then("Entries response should have at least one result like")
    public void assertEntriesResponseOneResult(Entries expectedEntriesResult) {
        //Act
        Entries actualEntriesResult = endpoint.getEntriesResultByApiName(expectedEntriesResult.getApi());

        //Assert
        //TestNG assertion
        Assert.assertEquals(actualEntriesResult, expectedEntriesResult);
        //AssertJ assertion
        Assertions.assertThat(actualEntriesResult).isEqualTo(expectedEntriesResult);
    }
}
