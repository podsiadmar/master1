package projectName.runners;

import common.CommonRunnerConfig;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/resources/projectName/features"},
        glue = {"projectName/steps"})
public class ApiRunner extends CommonRunnerConfig {
}
