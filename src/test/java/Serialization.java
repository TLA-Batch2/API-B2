import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import pojo.Student;

//import static io.restassured.RestAssured.*;

public class Serialization {

    @Test
    void test01(){
        Student student = new Student();
        student.setFirstName("Mike");
        student.setLastName("Tyson");
        student.setEmail("mike@tyson.com");
        student.setBatch(99);

        RestAssured.baseURI = "https://tla-school-api.herokuapp.com/api/school/resources/students";
        RequestSpecification request = RestAssured.given();

        request.queryParam("key", "d03e989018msh7f4691c614e87a9p1a8181j")
                .contentType(ContentType.JSON)
                .body(student)
                .when()
                .post()
                .then()
                .statusCode(200)
                .log().body();
    }
}
