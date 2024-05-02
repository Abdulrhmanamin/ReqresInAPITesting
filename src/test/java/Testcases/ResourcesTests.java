package Testcases;

import Services.ResourceServices;
import SharedUtils.ResourcesUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class ResourcesTests {

    ResourceServices resourceServices =new ResourceServices();
    ResourcesUtils resourcesUtils = new ResourcesUtils();

    @Test(priority = 1)
    @Description("this test for check if all rescoures of page one is found")
    @Severity(SeverityLevel.CRITICAL)
    public void checkIfGetAllResourcesInPageOne(){
        Response response = resourceServices.getAllResourcesInPageOne();
        response
                .then()
                .log().all()
                .assertThat().body("data",Matchers.hasSize(6)).and()
                .assertThat().body("page",is(equalTo(1))).and()
                .assertThat().body("per_page",is(equalTo(6))).and()
                .assertThat().body("total",is(equalTo(12)))
                .extract().response();
        int resourceId =response.jsonPath().getInt("data[1].id");
        resourcesUtils.setResourceId(resourceId);
    }
    @Test(priority = 1)
    @Description("this test for check if all rescoures of page Two is found")
    @Severity(SeverityLevel.CRITICAL)
    public void checkIfGetAllResourcesInPageTwo(){
        Response response = resourceServices.getAllResourcesInPageTwo();
        response
                .then()
                .log().all()
                .assertThat().body("data",Matchers.hasSize(6)).and()
                .assertThat().body("page",is(equalTo(2))).and()
                .assertThat().body("per_page",is(equalTo(6))).and()
                .assertThat().body("total",is(equalTo(12)));
    }
    @Test(priority = 2)
    @Description("this test for get resource By Id")
    @Severity(SeverityLevel.CRITICAL)
    public void checkIfGetResourceById(){
        Response response =resourceServices.getResourceById(resourcesUtils.getResourceId());
        response
                .then()
                .log().all()
                .assertThat().body("data.id",is(equalTo(2))).and()
                .assertThat().body("data.name",is(equalTo("fuchsia rose")));
    }
    @Test(priority = 2)
    @Description("this test for checking of empty list when search by invalid id ")
    @Severity(SeverityLevel.CRITICAL)
    public void checkResultOfInvalidId(){
        Response response =resourceServices.getResourceById(23);
        response
                .then()
                .log().all()
                .assertThat().statusCode(404).and()
                .assertThat().body("isEmpty()", Matchers.is(true));
    }
}
