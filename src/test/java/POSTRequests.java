import io.restassured.RestAssured;
import io.restassured.http.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.JsonUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class POSTRequests {
    String taskURL = "https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse";

    @Test(description = "serializing using Map")
    void test01(){
        Map<String, String> map = new HashMap<>();
        map.put("name", "Java");
        map.put("duration", "3 months");

        System.out.println(map);

        JSONObject jsonObject = new JSONObject(map);
        System.out.println(jsonObject);
    }

    @Test(description = "serializing without using Map")
    void test02(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Java");
        jsonObject.put("duration", "3 months");

        System.out.println(jsonObject);
    }

    @Test(description = "create a Json object from .json file")
    void test03(){
        JSONObject jsonObject = JsonUtils.readJsonObjectFromJsonFile("courseObject.json");
        System.out.println(jsonObject);
    }

    //NOTE: Sending POST Request

    @Test(description = "basic POST")
    void test04(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "API course");
        jsonObject.put("duration", "2 weeks");

        given()
                .contentType(ContentType.JSON)
                .body(jsonObject)
                .when()
                .post(taskURL)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(description = "Sending with header parameters")
    void test05(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "API course 1");
        jsonObject.put("duration", "2 weeks");

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject)
                .when()
                .post(taskURL)
                .then()
                .statusCode(200)
        .log().body();
    }

    @Test(description = "POST request with parameters")
    void test06(){
        RestAssured.baseURI = "https://tla-school-api.herokuapp.com/api/school/resources";
        RequestSpecification httpRequest = RestAssured.given();

        JSONObject student = new JSONObject();
        student.put("firstName", "Anderson");
        student.put("lastName", "Cooper");
        student.put("email", "acooper@gg.com");
        student.put("batch", 2);

        httpRequest.header("content-type", "application/json");
        httpRequest.queryParam("key", "qweasddfhdsrqwer12341234");
        httpRequest.body(student);

        Response response = httpRequest.request(Method.POST, "/students");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        Assert.assertEquals(statusCode, 200);
    }

    //Class task create and instructor. Endpoint: https://tla-school-api.herokuapp.com/api/school/resources/instructors
    /*
            "id": 2,
            "firstName": "Bob",
            "lastName": "Gordon",
            "phoneNumber": "(000)-00-0000",
            "email": "test@yahoo.com",
            "courses": "Selenium, API",
     */
    @Test(description = "Class task")
    void test061(){
        //needs implementation
    }

    /*
    {
    "name": "Sky Cloud",
    "email": "{{testEmail}}",
    "gender": "Male",
    "status": "Active"
}
     */
    @Test(description = "POST request using Bearer's token")
    void test070(){
        String token = "2e93a51c1044d5e261dd2c08198f9a02d1cb00edb22a875c534e1589ff0f8e73";

        JSONObject userObject = new JSONObject();
        userObject.put("name", "Cloudy Weather");
        userObject.put("email", "cloud@weather.com");
        userObject.put("gender", "Male");
        userObject.put("status", "Active");

        given()
                .header("Authorization", "Bearer " + token)
                .header("content-type", ContentType.JSON)
                .body(userObject)
                .when()
                .post("https://gorest.co.in/public-api/users")
                .then()
                .statusCode(200)
                .log().body();
    }


}
