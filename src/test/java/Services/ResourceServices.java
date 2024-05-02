package Services;

import SharedUtils.Properties;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ResourceServices {
    public Response getAllResourcesInPageOne (){
        return given()
                .baseUri(Properties.base_Url)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(Properties.resourceEP);
    }
    public Response getAllResourcesInPageTwo (){
        return given()
                .baseUri(Properties.base_Url)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(Properties.resourceEP+Properties.pageTwo);
    }

    public Response getResourceById (int resourceId){
        return given()
                .baseUri(Properties.base_Url)
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(Properties.resourceEP+"/"+resourceId);
    }
}
