package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/resources"},
        glue = {"stepDefinitions"},
        tags = "@E2E",
        plugin = {"pretty", "html:target/htmlreport/cucumber-report.html",
                "json:target/htmlreport/cucumber-report.json"}
                )

public class testRunner {

}
