package testUtils;

import io.restassured.response.Response;
import io.restassured.specification.PreemptiveAuthSpec;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestAssuredContext {
    private Response response;
    private RequestSpecification requestSpecification;
    private PreemptiveAuthSpec preemptiveAuthSpec;
}
