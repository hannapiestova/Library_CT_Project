package com.libraryAutomation.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber.json",
                 "rerun:target/rerun.txt"
                //this line will generate list of scenarios that failed during execution
        },
        features = "src/test/resources/features",
        glue = "com/libraryAutomation/step_definitions",
        dryRun = false,
        tags = "@modules_librarian"

)

public class CukesRunner {
}
