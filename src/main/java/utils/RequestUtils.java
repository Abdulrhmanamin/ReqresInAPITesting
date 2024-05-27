package utils;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import configurations.Configuration;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class RequestUtils {

    public static RequestSpecification createRequestWithBody(HashMap<String, Object> requestBody) {
        return given()
                .baseUri(Configuration.getBaseUrl())
                .contentType(ContentType.JSON)
                .body(requestBody);
    }

    public static RequestSpecification createRequestWithParams(HashMap<String, Object> paramsData) {
        return given()
                .baseUri(Configuration.getBaseUrl())
                .contentType(ContentType.JSON)
                .params(paramsData);
    }
    public static RequestSpecification createRequestWithoutParamsOrBody() {
        return given()
                .baseUri(Configuration.getBaseUrl())
                .contentType(ContentType.JSON);
    }
}
