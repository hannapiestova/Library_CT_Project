package com.libraryAutomation.step_definitions;

import com.libraryAutomation.pages.librarian.BookPage_lib;
import static com.libraryAutomation.utilities.BrowserUtils.*;

import com.libraryAutomation.pages.librarian.UsersPage;
import com.libraryAutomation.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AddUserStepDefinitions {

    UsersPage usersPage = new UsersPage();

    @Given("librarian navigates to {string} page")
    public void librarian_navigates_to_page(String module) {
        usersPage.navigateTo(module);
        waitForElementToBoVisible(usersPage.getUserManagementButton());
        Assert.assertTrue(usersPage.checkUrl().contains("users"));

    }

    @Then("librarian clicks on add user button")
    public void librarian_clicks_on_add_user_button() {

        waitForElementToBoVisible(usersPage.getAddUser()).click();
        usersPage.addUser("Librarian","ACTIVE");
        Assert.assertTrue(waitForPresenceOfElement("//*[text()='The user has been created.']").isDisplayed());


    }

    @Then("librarian clicks on edit user button")
    public void librarian_clicks_on_edit_user_button() {
        usersPage.editUser("2");
        Assert.assertTrue(waitForPresenceOfElement("//*[text()='The user updated.']").isDisplayed());
    }
    @Then("librarian is able to edit user info")
    public void librarian_is_able_to_edit_user_info() {

    }
}
