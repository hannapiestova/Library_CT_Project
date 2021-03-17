package com.libraryAutomation.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/smoke_test_default_repost.html",
                "json:target/cucumber_smoke_test.json"
        },
        features = "src/test/resources/features",
        glue = "com/libraryAutomation/step_definitions",
        dryRun = false,
        tags = "@smoke_test"

)
public class SmokeTestRunner {
}
