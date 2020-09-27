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

public class DELETERequest {

    String taskURL = "https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse";

    @Test(description = "Delete a course")
    void test01(){
        given()
                .queryParam("name", "API course1")
                .when()
                .delete(taskURL)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(description = "Delete instructor using API key")
    void test02(){
        given()
                .header("content-type", ContentType.JSON)
                .header("Authorization", "d03e989018msh7f4691c614e87a9p1a8181j")
                .pathParam("instructorID", "5f6f760688158f0017c40038")
                .when()
                .delete("https://tla-school-api.herokuapp.com/api/school/resources/instructors/{instructorID}")
                .then()
                .statusCode(200)
                .log().body();
    }

}
