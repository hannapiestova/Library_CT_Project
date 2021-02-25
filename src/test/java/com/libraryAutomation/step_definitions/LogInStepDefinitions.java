package com.libraryAutomation.step_definitions;

import com.libraryAutomation.pages.LogInPage;
import static com.libraryAutomation.utilities.BrowserUtils.*;

import com.libraryAutomation.utilities.BrowserUtils;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogInStepDefinitions {
    LogInPage logInPage = new LogInPage();


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        waitForPageToLoad(20);
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
    }

    @When("user login as a {string}")
    public void user_login_as_a(String string) {
        logInPage.login(string);
    }

    @Then("user is on the {string}")
    public void user_is_on_the(String string) {

         waitForUrlToContain(string);
        Assert.assertTrue(logInPage.checkUrl().endsWith(string));
    }








}
