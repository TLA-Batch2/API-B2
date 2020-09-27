package step_defs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.RestAssured;
import util.ConfigReader;

public class Hooks {
    ScenarioContext scontext;

    public Hooks(ScenarioContext scenarioContext){
        this.scontext = scenarioContext;
    }

    @Before
    public void beforeHooks(Scenario scenario){
        RestAssured.baseURI = ConfigReader.readProperty("baseURI", "src/test/resources/properties/env.properties");
        scontext.scenario = scenario;
    }

    @After
    public void afterHooks(){
    }
}
