package common.steps;

import common.IEndpoint;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import lombok.SneakyThrows;
import testUtils.RestAssuredContext;
import utils.TestContext;

import java.util.ArrayList;

@SuppressWarnings({"SameParameterValue", "unused"})
public class Base_Steps {

    protected final TestContext testContext;
    protected final RestAssuredContext restAssuredContext;
    private IEndpoint endpoint;

    public void setEndpoint(IEndpoint endpoint) {
        this.endpoint = endpoint;
    }

    public Base_Steps(TestContext testContext, RestAssuredContext restAssuredContext) {
        this.testContext = testContext;
        this.restAssuredContext = restAssuredContext;
    }

    //region GET
    protected void sendGetRequest(String path, boolean isResponseConvertable) {
        getRequest(path, isResponseConvertable);
    }

    protected void sendGetRequest(String path) {
        getRequest(path, false);
    }

    private void getRequest(String path, boolean isResponseConvertable) {
        Response response = restAssuredContext.getRequestSpecification()
                .when()
                .get(path)
                .then().extract().response();
        restAssuredContext.setResponse(response);
        if (response.getStatusCode() == 200 && isResponseConvertable) {
            endpoint.convertResponseToDataModel(response.asString());
        }
    }
    //endregion

    //region POST
    protected void sendPostRequest(String path, String requestBody, boolean isResponseConvertable) {
        postRequest(path, requestBody, isResponseConvertable);
    }

    protected void sendPostRequest(String path, String requestBody) {
        postRequest(path, requestBody, false);
    }

    private void postRequest(String path, String requestBody, boolean isResponseConvertable) {
        Response response = restAssuredContext.getRequestSpecification()
                .when()
                .body(requestBody).log().body()
                .post(path)
                .then().extract().response();
        restAssuredContext.setResponse(response);
        if (response.getStatusCode() == 200 && isResponseConvertable) {
            endpoint.convertResponseToDataModel(response.asString());
        }
    }
    //endregion

    //region PUT
    protected void sendPutRequest(String path, String requestBody, boolean isResponseConvertable) {
        putRequest(path, requestBody, isResponseConvertable);
    }

    protected void sendPutRequest(String path, String requestBody) {
        putRequest(path, requestBody, false);
    }

    private void putRequest(String path, String requestBody, boolean isResponseConvertable) {
        Response response = restAssuredContext.getRequestSpecification()
                .when()
                .body(requestBody).log().body()
                .put(path)
                .then().extract().response();
        restAssuredContext.setResponse(response);
        if (response.getStatusCode() == 200 && isResponseConvertable) {
            endpoint.convertResponseToDataModel(response.asString());
        }
    }
    //endregion

    //region DELETE
    protected void sendDeleteRequest(String path,  boolean isResponseConvertable) {
        deleteRequest(path, isResponseConvertable);
    }

    protected void sendDeleteRequest(String path) {
        deleteRequest(path, false);
    }

    public void deleteRequest(String path, boolean isResponseConvertable) {
        Response response = restAssuredContext.getRequestSpecification()
                .when()
                .delete(path)
                .then().extract().response();
        restAssuredContext.setResponse(response);
        if (response.getStatusCode() == 200 && isResponseConvertable) {
            endpoint.convertResponseToDataModel(response.asString());
        }
    }
    //endregion

    @SuppressWarnings("SameParameterValue")
    //region GET with wait
    protected boolean sendGetRequestAndWaitForContent(String path, int maxWait, boolean isResponseConvertable) {
        return getRequestWithWait(path, maxWait, isResponseConvertable);
    }

    protected boolean sendGetRequestAndWaitForContent(String path, int maxWait)  {
        return getRequestWithWait(path, maxWait, false);
    }

    @SneakyThrows
    private boolean getRequestWithWait(String path, int maxWait, boolean isResponseConvertable) {
        for (int i = 1; i <= maxWait; i++) {
            Thread.sleep(500);
            Response response = restAssuredContext.getRequestSpecification()
                    .when()
                    .get(path)
                    .then().extract().response();
            if (!response.asString().equals("[]")) {
                restAssuredContext.setResponse(response);
                if (response.getStatusCode() == 200 && isResponseConvertable) {
                    endpoint.convertResponseToDataModel(response.asString());
                }
                return true;
            }
        }
        return false;
    }
    //endregion

    protected void clearReqQueryParams() {
        FilterableRequestSpecification requestSpecification = (FilterableRequestSpecification) restAssuredContext.getRequestSpecification();
        new ArrayList<>(requestSpecification.getQueryParams().keySet()).forEach(requestSpecification::removeQueryParam);
    }


}