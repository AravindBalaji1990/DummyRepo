package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = {"stepdefinition_swaglab"},
        tags = "@Testscenariooutline",
        dryRun = false, // this will cehck only forhte feature to package information, if we want ot runthe script then dryrun should be false
        monochrome = true,
        plugin = {"pretty", "html:HTMLReport.html"})
public class Runner {
}
