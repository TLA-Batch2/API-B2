package __testNGTest;

import io.restassured.RestAssured;
import io.restassured.http.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class DataDrivenRequests {
    String taskURL = "https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse";

    //NOTE: POST Request using DataProvider
    @DataProvider(name = "courseNames")
    public Object[][] courseData(){
            return new Object[][]{
                    {"RestAssured", "2 days"},
                    {"Gson", "30 min"},
                    {"Google", "2 years"}
            };
    }

    @Test(dataProvider = "courseNames", description = "basic POST")
    void test01(String courseName, String duration){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", courseName);
        jsonObject.put("duration", duration);

        given()
                .contentType(ContentType.JSON)
                .body(jsonObject)
                .when()
                .post(taskURL)
                .then()
                .statusCode(200)
                .log().body();
    }

    @DataProvider(name = "courses")
    public Object[] courses(){
        return new Object[]{
                "RestAssured", "Gson", "Google"
        };
    }

    @Test(dataProvider = "courses", description = "Delete courses with DataProvider")
    void test02(String course){
        given()
                .queryParam("name", course)
                .when()
                .delete(taskURL)
                .then()
                .statusCode(200)
                .log().body();
    }

}
