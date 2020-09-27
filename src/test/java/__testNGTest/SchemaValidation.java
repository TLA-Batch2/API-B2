package __testNGTest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SchemaValidation {

    @Test(description = "Store body as a string and validate the schema")
    void test01(){
        String responseBody = given()
                .queryParam("name", "Schema Validation")
                .get("https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse")
                .body().asString();

        System.out.println(responseBody);
        assertThat(responseBody, matchesJsonSchemaInClasspath("data/jsonSchemas/sdetCourseSchema.json"));
    }

    @Test(description = "validate schema without storing in a variable")
    void test02(){
        given()
                .queryParam("name", "Schema Validation")
                .get("https://tla-school-api.herokuapp.com/api/school/programs/sdetcourse")
                .then()
                .body(matchesJsonSchemaInClasspath("data/jsonSchemas/sdetCourseSchema.json"))
                .log().body();
    }
}
