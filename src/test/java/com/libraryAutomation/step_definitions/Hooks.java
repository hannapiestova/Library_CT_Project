package com.libraryAutomation.step_definitions;

import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(Scenario scenario){

        System.out.println(scenario.getName());
        Driver.getDriver().manage().window().maximize();
    }

    @After
    public void teardown(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot takeScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[]image= takeScreenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(image,"image/png",scenario.getName());
        }
        Driver.close();
    }

}
