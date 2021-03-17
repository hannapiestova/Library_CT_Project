package com.libraryAutomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/failed-report.html",
                "json:target/failed-cucumber.json",
        },
        features = "@target/rerun.txt",
        glue = "com/libraryAutomation/step_definitions"

)

public class FailedRunner {
}
