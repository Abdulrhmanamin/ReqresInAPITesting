package Testcases;

import Services.UserServices;
import model.UserModel;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class UserTests {
    private final UserServices userServices = new UserServices();
    UserModel userUtils = new UserModel();




    @Test(priority = 1)
    @Description("thus test for create user using valid data")
    @Severity(SeverityLevel.CRITICAL)
    public void createUserWithValidData(){
        HashMap<String,Object> bodyData = new HashMap<>();
        bodyData.put("name","abdo");
        bodyData.put("job","leader");
        Response response = userServices.createUserAPI(bodyData);
        response
                .then()
                .log().all()
                .assertThat().body("name",is(equalTo("abdo")))
                .extract().response();
        int userId=response.jsonPath().getInt("id");
        userUtils.setUserID(userId);

    }
    @Test(priority = 2)
    @Description("this test for check if value updated or not")
    @Severity(SeverityLevel.CRITICAL)
    public void updateUserWithValidData(){
        HashMap<String,Object> bodyData = new HashMap<>();
        bodyData.put("name","abdooo");
        bodyData.put("job","lear");
        Response response = userServices.updateUserAPI(bodyData,userUtils.getUserID());
        response
                .then()
                .log().all()
                .assertThat().body("name",is(equalTo("abdooo"))).and()
                .assertThat().body("job",is(equalTo("lear")));
    }
    @Test(priority = 3)
    @Description("this test for delete user and return status code 204")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteUser(){
        Response response = userServices.deleteUserAPI(userUtils.getUserID());
        response
                .then()
                .log().all()
                .assertThat().statusCode(204);
    }
}
