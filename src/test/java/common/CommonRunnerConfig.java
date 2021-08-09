package common;

import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import java.io.IOException;

@CucumberOptions(
        glue = {"testUtils",
                "common/steps"},
        plugin = {"pretty", "summary",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"})
public class CommonRunnerConfig extends AbstractTestNGCucumberTests {

    @SuppressWarnings("EmptyMethod")
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeTest
    @Parameters({"url"})
    public void setUp(String url) {
        System.setProperty("url", url.equals("${env.URL}") ? "http://localhost:8080" : url);
    }

    @SuppressWarnings("EmptyMethod") //TODO delete after method will be implemented
    @Before()
    public void setupUsers() {
        //TODO check and add users
    }
}
