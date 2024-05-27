package Services;

import configurations.Configuration;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.RequestUtils;

import static io.restassured.RestAssured.given;

public class ResourceServices {
    public Response getAllResourcesInPageOne (){
        return RequestUtils.createRequestWithoutParamsOrBody()
                .log().all()
                .when()
                .get(Configuration.getEndpoint("resourceEp"));
    }
    public Response getAllResourcesInPageTwo (){
        return RequestUtils.createRequestWithoutParamsOrBody()
                .log().all()
                .when()
                .get(Configuration.getEndpoint("resourceEp")+ Configuration.getEndpoint("pageTwo"));
    }

    public Response getResourceById (int resourceId){
        return RequestUtils.createRequestWithoutParamsOrBody()
                .log().all()
                .when()
                .get(Configuration.getEndpoint("resourceEp")+resourceId);
    }
}
