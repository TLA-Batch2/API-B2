package __testNGTest;

import io.restassured.RestAssured;
import io.restassured.http.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
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

    @Test(description = "logging the results")
    void test03(){
        given()
                .when()
                .get(classURL + "/2")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(description = "assert specific detail of the response body")
    void test04(){
        given()
                .get(classURL + "/2")
                .then()
                .statusCode(200)
                .body("data.gender", equalTo("Male"))
                .log()
                .body();
    }

    @Test(description = "validate if response body contains given items")
    public void test05(){
        given()
                .get(classURL)
                .then()
                .body("data.name", hasItems("Aaditya Shukla Ret.", "Bankim Shah"))
                .log().body();
    }

    //class task: using taskURL verify courses like Java, Apache POI exists
    @Test
    void test051(){
        given()
                .get(taskURL)
                .then()
                .body("data.name", hasItems("Java", "Apache POI"))
                .log().body();
    }

    @Test(description = "extract header info")
    void test052(){
        Headers headers = given()
                .get(classURL).getHeaders();
        System.out.println(headers + "\n");
        System.out.println(headers.get("server")+"\n");

        Header header = given()
                .get(classURL)
                .headers()
                .get("content-type");
        System.out.println(header);
    }

    @Test(description = "extract cookie info")
    void test053(){
        given()
                .get(taskURL)
                .then()
                .statusCode(200)
                .cookie("connect.sid")
        .log().cookies();
    }

    @Test(description = "extract Cookie info")
    void test054(){
        Cookie cookie = given()
                .get("https://jsonplaceholder.typicode.com/users")
                .then()
                .statusCode(200)
                .extract()
                .detailedCookie("__cfduid");

        System.out.println(cookie.getDomain());
        System.out.println(cookie.getValue());
        System.out.println(cookie.getExpiryDate());
    }

    //Class task: using sdetCourse end point - Print out value of the cookie and check if cookie is secured
    @Test()
    void test055(){
        Cookie cookie = given()
                .get(taskURL)
                .getDetailedCookie("connect.sid");
        System.out.println(cookie.getValue());
        System.out.println(cookie.isSecured());
    }

    //NOTE PathParameters
    @Test()
    void test056(){
        String baseURL = "https://gorest.co.in/public-api";

        given()
                .when()
                .pathParam("resource", "comments")
                .get("https://gorest.co.in/public-api/{resource}")
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    //NOTE: using dataProvider with Path Parameters
    @DataProvider(name = "resourceData")
    public Object[] getResourceData(){
        return new Object[]{"users", "posts", "comments", "products"};
    }

    @Test(dataProvider = "resourceData", description = "pathParam with DataProvider")
    void test057(String resource){
        given()
                .when()
                .pathParam("resource", resource)
                .get("https://gorest.co.in/public-api/{resource}")
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    //Class task - https://jsonplaceholder.typicode.com - test
    @DataProvider(name = "resourceData2")
    public Object[] getResourceData2(){
        return new Object[]{"users", "posts", "comments", "albums", "photos", "todos"};
    }

    @Test(dataProvider = "resourceData2", description = "pathParam with DataProvider")
    void test058(String resource2){
        given()
                .when()
                .pathParam("resource", resource2)
                .get("https://jsonplaceholder.typicode.com/{resource}")
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    //NOTE: Query param
    @Test(description = "find a specific course")
    void test059(){
        given()
                .queryParam("name", "Selenium course")
                .get(taskURL)
                .then()
                .statusCode(200)
                .log()
                .body();
    }

    @Test(description = "chaining query params")
    void test060(){
        given()
                .queryParam("name", "Selenium course", "Java", "Java course")
                .get(taskURL)
                .then()
                .statusCode(200)
                .body("data.name",hasItems("Selenium course", "Java", "Java course"))
                .log()
                .body();
    }

    //Class task: Find course Java and validate it exists in the response body
    @Test()
    void test061(){
        given()
                .queryParam("name", "Java")
                .get(taskURL)
                .then()
                .statusCode(200)
                .body("data[0].name", equalTo("Java"))
                .log()
                .body();
    }

    @Test(description = "using google Places api")
    void test062(){
        given()
                .queryParam("location", "38.890759,-77.084747")
                .queryParam("radius", 1500)
                .queryParam("type", "school")
                .queryParam("key", "YourApiKey")
        .when()
                .get("https://maps.googleapis.com/maps/api/place/nearbysearch/json")
        .then()
                .statusCode(200)
                .body("results.name", hasItems("Strayer University", "The Merit School of Arlington"))
                .log().body();
    }

    @Test()
    void test063(){
        RestAssured.baseURI = "https://tla-school-api.herokuapp.com/api/school/resources";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "/students/5f67b0346c91e700178a82be");

        String responseBody = response.getBody().asString();
        int status = response.getStatusCode();

        System.out.println(responseBody);
        System.out.println();
        System.out.println(status);
    }

}
