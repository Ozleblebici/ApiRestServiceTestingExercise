package io.petstoreAPI.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-html-report","json:target/failedcucumber.json" },
        features = "@target/rerun.txt",
        glue= "api_DB_CucumberJunit/stepdefinitions"
)
public class FailedRunner {
}
