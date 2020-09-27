package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "step_defs",
        plugin = {
                "json:target/cucumber.json",
                "rerun:target/re-run.txt"
        },
        tags = "@sdetCourse"
        ,dryRun = false
)
public class RunnerTest extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = false)
    public Object[][] scenarios(){
        return super.scenarios();
    }
}
