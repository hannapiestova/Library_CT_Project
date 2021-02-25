package com.libraryAutomation.step_definitions;

import com.libraryAutomation.pages.LogInPage;
import com.libraryAutomation.pages.librarian.DashboardPage;
import com.libraryAutomation.pages.student.BooksPage_stu;
import com.libraryAutomation.utilities.ConfigurationReader;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

import static com.libraryAutomation.utilities.BrowserUtils.waitForElementToBoVisible;

public class ModulesStepDefinitions {
   LogInPage logInPage = new LogInPage();
   BooksPage_stu booksPage_stu = new BooksPage_stu();
   DashboardPage dashboardPage = new DashboardPage();


    @Given("student is on the home page")
    public void student_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        logInPage.studentLogIn();
    }
    @Then("student should see following modules")
    public void student_should_see_following_modules(List<String> modules) {
        waitForElementToBoVisible(booksPage_stu.getBooksBtn());
        Assert.assertEquals(modules,booksPage_stu.getModules());
    }


    @Given("librarian is on the home page")
    public void librarian_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        logInPage.librarianLogin();
    }


    @Then("librarian should see following modules")
    public void librarian_should_see_following_modules(List<String> modules) {

        waitForElementToBoVisible(dashboardPage.getDashboardButton());
        Assert.assertEquals(modules,dashboardPage.getModules());

    }
}
