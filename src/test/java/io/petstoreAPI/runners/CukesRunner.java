package io.petstoreAPI.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/default-cucumber-reports"},
        features = "src/test/resources/petstoreFeatures",
        glue = "io/petstoreAPI/stepDef",
        dryRun = false,
        tags = "@petStoreApi"
)
public class CukesRunner {
}
