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
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

public class Deserialization {

    String taskURL = "https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse";

    @Test
    void test01(){
        String name = given()
                .get(taskURL)
                .then()
                .statusCode(200)
                .extract()
                .path("data[0].name");

        System.out.println("\n" + name);
    }

    @Test
    void test02(){
        List<String> name = given()
                .get(taskURL)
                .then()
                .statusCode(200)
                .extract()
                .path("data.name");

        name.forEach(a -> System.out.println(a));
    }

    //Class task: using Students endpoint extract all student IDs(_id) and print out
    @Test
    void test03(){
        List<String> ids = given()
                .get(taskURL)
                .then()
                .statusCode(200)
                .extract()
                .path("data._id");

        ids.forEach(a -> System.out.println(a));
    }

}
