package common.steps;

import static io.restassured.RestAssured.given;
import static testUtils.Users.userRoles;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import io.restassured.specification.FilterableRequestSpecification;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.PreemptiveAuthSpec;
import io.restassured.specification.RequestSpecification;
import testUtils.RestAssuredContext;
import utils.TestContext;

public class Common_Steps extends Base_Steps {

    public Common_Steps(TestContext testContext, RestAssuredContext restAssuredContext) {
        super(testContext, restAssuredContext);
    }

    // region Given
    @Given("User credentials are {string} and password {string}")
    public void userCredentials(String userName, String userPassword) {
        testContext.setUserName(userName);
        testContext.setUserPassword(userPassword);
    }

    @Given("Setup request specification with user credentials {string} and password {string}")
    public void setupRequestSpecs(String userName, String userPassword) {
        RequestSpecification requestSpecification = given()
                .baseUri(System.getProperty("url"))
                .auth()
                .preemptive()
                .basic(userName, userPassword)
                .contentType(ContentType.JSON)
                .header("User-Agent", "RestAssured \uD83D\uDC38")
                .header("X-Requested-With", "XMLHttpRequest");
        restAssuredContext.setRequestSpecification(requestSpecification);
    }

    @Given("Set request content type to multipart")
    public void setupRequestContentType(){
        RequestSpecification requestSpecification = given()
                .contentType(ContentType.MULTIPART);
        restAssuredContext.setRequestSpecification(requestSpecification);
    }

    @Given("Add file multipart to request with path {}")
    public void addMultipartDoForm(String path){
        File file = new File(path);
        RequestSpecification requestSpecification = given()
                .multiPart(file);
        restAssuredContext.setRequestSpecification(requestSpecification);
    }

    @Given("Setup base request specification")
    public void setupPreemptiveAuthSpec() {
        PreemptiveAuthSpec preemptiveAuthSpec = given()
                .baseUri(System.getProperty("url"))
                .auth()
                .preemptive();
        restAssuredContext.setPreemptiveAuthSpec(preemptiveAuthSpec);
    }

    @Given("Attach header to request specification with key {string} and value {string}")
    public void attachHeader(String key, String value) {
        RequestSpecification requestSpecification = restAssuredContext.getRequestSpecification();
        restAssuredContext.setRequestSpecification(requestSpecification.header(key, value));
    }

    @Given("Detach header from request specification with key {string}")
    public void detachHeader(String key) {
        FilterableRequestSpecification requestSpecification = (FilterableRequestSpecification) restAssuredContext.getRequestSpecification();
        requestSpecification.removeHeader(key);
    }
    //endregion

    //region When
    @When("Set user credentials for {}")
    public void setUserCredentials(String userRole) {
        String userName = userRoles.get(userRole).getUserName();
        String userPassword = userRoles.get(userRole).getUserPassword();
        Allure.step(userRole + " with name: " + userName + "and password: " + userPassword);
        RequestSpecification requestSpecification = restAssuredContext.getPreemptiveAuthSpec()
                .basic(userName, userPassword)
                .contentType(ContentType.JSON)
                .header("User-Agent", "RestAssured \uD83D\uDC38")
                .header("X-Requested-With", "XMLHttpRequest");
        restAssuredContext.setRequestSpecification(requestSpecification);
    }

    @When("User defines request with body parameter {string} and value {string}")
    public void defineParams(String key, String value) {
        restAssuredContext.getRequestSpecification().param(key, value);
    }

    @When("User defines request with query parameter {string} and value {string}")
    public void defineQueryParam(String key, String value) {
        restAssuredContext.getRequestSpecification().queryParam(key, value);
    }

    @When("User defines request with query parameter {} with a list of values")
    public void defineQueryParams(String key, List<String> value) {
        restAssuredContext.getRequestSpecification().queryParam(key, value);
    }
    //endregion

    //region Then
    @Then("Response status should be {}")
    public void assertResponseStatusCode(String code) {
        //Arrange
        int expectedStatusCode = Integer.parseInt(code);

        //Act
        int actualStatusCode = restAssuredContext.getResponse().getStatusCode();
        //Assert
        if (actualStatusCode != 200) {
            System.out.println("Response body: " + restAssuredContext.getResponse().asString());
            System.out.println("Response status line: " + restAssuredContext.getResponse().statusLine());
        }
        Assert.assertEquals(actualStatusCode, expectedStatusCode);
    }

    @Then("Response should contain {int} element(s)")
    public void assertAmountOfItemsInResponse(int expectedCount) {
        Assert.assertEquals(getActualCount(), expectedCount);
    }

    @Then("Response should be non-empty")
    public void assertNonEmptyResponse() {
        Assert.assertNotEquals(getActualCount(), 0);
    }

    @Then("Response should be empty")
    public void assertEmptyResponse() {
        Assert.assertEquals(getActualCount(), 0);
    }

    private int getActualCount() {
        Response response = restAssuredContext.getResponse();
        JsonPath jsonPath = new JsonPath(response.asString());
        int actualCount = 0;

        if (jsonPath.get() instanceof ArrayList) {
            actualCount = jsonPath.getList("$").size();
        } else if (jsonPath.get() instanceof LinkedHashMap) {
            actualCount = jsonPath.getMap("$").size();
        }
        return actualCount;
    }

    @Then("Response body should be {string}")
    public void checkIfResponseBodyIs(String expectedString) {
        //Act
        String actualResponseAsString = restAssuredContext.getResponse().asString();

        //Assert
        Assert.assertEquals(actualResponseAsString, expectedString);
    }

    @Then("Response should match regex {string}")
    public void checkIfResponseBodyMatchesRegex(String regexString) {
        //Act
        String actualResponseAsString = restAssuredContext.getResponse().asString();

        //Assert
        Assert.assertTrue(actualResponseAsString.matches(regexString), actualResponseAsString);
    }


    //endregion
}