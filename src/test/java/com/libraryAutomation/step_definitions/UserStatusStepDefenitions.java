package com.libraryAutomation.step_definitions;

import static com.libraryAutomation.utilities.BrowserUtils.*;
import com.libraryAutomation.pages.LogInPage;
import com.libraryAutomation.pages.librarian.DashboardPage;
import com.libraryAutomation.pages.librarian.UsersPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.awt.*;
import java.util.List;

public class UserStatusStepDefenitions {

    LogInPage logInPage=new LogInPage();
    UsersPage usersPage=new UsersPage();
    DashboardPage dashboardPage=new DashboardPage();


    @Given("the user \\(Librarian) on the homepage")
    public void the_user_librarian_on_the_homepage() {
      logInPage.librarianLogin();
    }

    @When("the user click users moudle")
    public void the_user_click_users_moudle()  {
        waitForElementToBeClickable(dashboardPage.getDashboardButton());
       dashboardPage.usersBtnClick();
    }
    @When("the user click Status dopdown")
    public void the_user_click_status_dopdown(){
        waitForElementToBeClickable(usersPage.getAddUser());
        usersPage.statusClick();
    }
    @Then("the user should see the following options:")
    public void the_user_should_see_the_following_options(List<String> expected){
        Assert.assertEquals(usersPage.statusInfo(),expected);
    }


}
