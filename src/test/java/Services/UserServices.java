package Services;

import SharedUtils.Properties;
import SharedUtils.UserUtils;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class UserServices {



public Response RegesterApi(HashMap<String,String> bodyData){
    return given()
            .baseUri(Properties.base_Url)
            .contentType(ContentType.JSON)
            .body(bodyData)
            .log().all()
            .when()
            .post(Properties.registerEP);

}
public Response createUserAPI (HashMap<String,String> bodyData){
    return given()
            .baseUri(Properties.base_Url)
            .contentType(ContentType.JSON)
            .body(bodyData)
            .log().all()
            .when()
            .post(Properties.userEP);
}
public Response updateUserAPI (HashMap<String,String> bodyData,int userId){
    return given()
            .baseUri(Properties.base_Url)
            .contentType(ContentType.JSON)
            .body(bodyData)
            .log().all()
            .when()
            .put(Properties.userEP+userId);
    }
public Response deleteUserAPI (int userId){
    return given()
            .baseUri(Properties.base_Url)
            .log().all()
            .when()
            .delete(Properties.userEP+userId);
}
}
