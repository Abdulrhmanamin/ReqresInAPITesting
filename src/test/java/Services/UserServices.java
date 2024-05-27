package Services;

import configurations.Configuration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.RequestUtils;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserServices {



public Response RegesterApi(HashMap<String,Object> bodyData){
    return RequestUtils.createRequestWithBody(bodyData)
            .log().all()
            .when()
            .post(Configuration.getEndpoint("registerEp"));

}
public Response createUserAPI (HashMap<String,Object> bodyData){
    return RequestUtils.createRequestWithBody(bodyData)
            .log().all()
            .when()
            .post(Configuration.getEndpoint("userEp"));
}
public Response updateUserAPI (HashMap<String,Object> bodyData,int userId){
    return RequestUtils.createRequestWithBody(bodyData)
            .log().all()
            .when()
            .put(Configuration.getEndpoint("userEp")+userId);
    }
public Response deleteUserAPI (int userId){
    return RequestUtils.createRequestWithoutParamsOrBody()
            .log().all()
            .when()
            .delete(Configuration.getEndpoint("userEp")+userId);
}
}
