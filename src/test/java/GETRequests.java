import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GETRequests {
    //NOTE: https://gorest.co.in/public-api/users
    //Class task: https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse

    String classURL = "https://gorest.co.in/public-api/users";
    String taskURL = "https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse";

    @Test(description = "Get body of the request")
    void test01(){
        Response response = RestAssured.get("https://gorest.co.in/public-api/users");
        response.getBody().prettyPrint();
    }

    @Test(description = "class task")
    void test011(){
        Response response = RestAssured.get("https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse");
        response.getBody().print();
        System.out.println(response.getHeaders());
    }

    @Test(description = "apply assertions")
    void test02(){
        given()
                .when()
                .get(classURL)
                .then()
                .statusCode(200);
    }

}
