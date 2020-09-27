package __testNGTest;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

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

    //NOTE: Parse using .jsonPath method

    @Test(description = "static way of getting data out of json object")
    void test04(){
        String companyName = given()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .jsonPath()
                .get("company.name");

        System.out.println(companyName);
    }

    @Test(description = "using objects Response and JsonPath")
    void test05(){
        Response response = given()
                .get("https://jsonplaceholder.typicode.com/users/1");
        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.getString("address.geo.lat"));
    }

    @Test
    void test06(){
        List<String> companyNames = given()
                .get("https://jsonplaceholder.typicode.com/users")
                .jsonPath()
                .getList("company.name");

        companyNames.forEach( a -> System.out.println(a));
    }

    @Test
    void test07(){
        Map<String, String> address = given()
                .get("https://jsonplaceholder.typicode.com/users/1")
                .jsonPath()
                .getMap("address");

        System.out.println(address.get("street"));
        System.out.println(address.get("zipcode"));
    }
}
