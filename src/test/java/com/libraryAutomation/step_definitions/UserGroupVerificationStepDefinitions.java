package com.libraryAutomation.step_definitions;

import com.libraryAutomation.pages.librarian.UsersPage;
import static com.libraryAutomation.utilities.BrowserUtils.*;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;



public class UserGroupVerificationStepDefinitions {

    UsersPage usersPage = new UsersPage();
    @Then("librarian clicks on user group button")
    public void librarian_clicks_on_user_group_button() {
        waitForElementToBeClickable(usersPage.getUserGroups()).click();
    }

    @Then("librarian should see the following options")
    public void librarian_should_see_the_following_options(List<String> userGroups) {
        Assert.assertEquals(userGroups,usersPage.user_groups());
    }
}
