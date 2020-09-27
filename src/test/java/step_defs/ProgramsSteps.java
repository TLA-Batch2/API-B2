package step_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import util.ConfigReader;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProgramsSteps {
    ScenarioContext scontext;

    public ProgramsSteps(ScenarioContext scenarioContext){
        scontext = scenarioContext;
    }

    @Given("Resource {string} is up and running")
    public void resource_is_up_and_running(String resourceName) {
        scontext.request = RestAssured.given();
        scontext.request
                .basePath(ConfigReader.readProperty(resourceName, "src/test/resources/properties/env.properties"));
        scontext.scenario.log("Validating resource: " + resourceName);
    }

    @When("I send GET request using query parameter {string} equal to {string}")
    public void iSendGETRequestUsingQueryParameterEqualTo(String key, String value) {
        scontext.response = scontext.request
                .queryParam(key, value)
                .get();
        scontext.scenario.log("GET Request with query params: " + key + " | " + value);
    }

    @Then("Response code should be {int}")
    public void responseCodeShouldBe(int responseCode) {
        assertThat(scontext.getStatusCode(), is(responseCode));
        scontext.scenario.log("Expected Response code: " + responseCode + " | Actual code was: " + scontext.getStatusCode());
    }

    @Then("Print out and log the response body")
    public void printOutAndLogTheResponseBody() {
        scontext.response.body().prettyPrint();
        scontext.scenario.log(scontext.getResponseBody());
    }
}
