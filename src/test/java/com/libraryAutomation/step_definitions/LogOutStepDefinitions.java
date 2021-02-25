package com.libraryAutomation.step_definitions;

import com.libraryAutomation.pages.student.BooksPage_stu;
import com.libraryAutomation.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LogOutStepDefinitions {
    BooksPage_stu booksPage_stu = new BooksPage_stu();

    @Then("user logout as a {string}")
    public void userLogoutAsA(String role) {

        booksPage_stu.logout(role);
       Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("login"));
    }
}
